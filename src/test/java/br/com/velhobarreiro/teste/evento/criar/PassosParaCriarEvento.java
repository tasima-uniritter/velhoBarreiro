package br.com.velhobarreiro.teste.evento.criar;

import java.util.Calendar;

import org.junit.Assert;

import br.com.velhobarreiro.teste.passosteste.PassosParaTeste;
import br.com.velhorbarreiro.dto.EventoDTO;
import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.service.EventoService;
import br.com.velhorbarreiro.util.CalendarUtil;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PassosParaCriarEvento extends PassosParaTeste {

	private EventoDTO eventoDTO;
	private Evento eventoCriado;
	private String mensagemErro;

	@Override
	@Before
	public void prepararCenario() {
		super.prepararCenario();
	}

	@Dado("^que quero criar um evento$")
	public void que_quero_criar_um_evento() throws Throwable {
		eventoDTO = new EventoDTO();
	}

	@Dado("^que não informo o nome$")
	public void que_não_informo_o_nome() throws Throwable {
		eventoDTO.setNome(null);
	}

	@Dado("^que informo data de validade$")
	public void que_informo_data_de_validade() throws Throwable {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 2);
		eventoDTO.setDataValidade(data);
	}

	@Quando("^salvar o evento$")
	public void salvar_o_evento() throws Throwable {
		try {
			EventoService eventoService = new EventoService();
			eventoCriado = eventoService.criar(eventoDTO);
		} catch (Exception e) {
			mensagemErro = e.getMessage();
		}
	}

	@Então("^deve exibir a mensagem de obrigatoriedade \"(.*?)\"$")
	public void deve_exibir_a_mensagem_de_obrigatoriedade(String mensagemEsperada) throws Throwable {
		Assert.assertEquals(mensagemEsperada, mensagemErro);
	}

	@Dado("^que não informo a data de validade$")
	public void que_não_informo_a_data_de_validade() throws Throwable {
		eventoDTO.setDataValidade(null);
	}

	@Dado("^que informo o nome$")
	public void que_informo_o_nome() throws Throwable {
		eventoDTO.setNome("final");
	}

	@Dado("^que informo um nome com mais de (\\d+) caracteres$")
	public void que_informo_um_nome_com_mais_de_caracteres(int numeroMaximoCaracteres) throws Throwable {
		StringBuilder builderNome = new StringBuilder();
		for (int i = 0; i <= numeroMaximoCaracteres; i++) {
			builderNome.append("a");
		}
		eventoDTO.setNome(builderNome.toString());
	}

	@Então("^deve exibir a mensagem \"(.*?)\"$")
	public void deve_exibir_a_mensagem(String menssagemEsperada) throws Throwable {
		Assert.assertEquals(menssagemEsperada, mensagemErro);
	}

	@Dado("^informo uma data de validade menor que a data atual$")
	public void informo_uma_data_de_validade_menor_que_a_data_atual() throws Throwable {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, -1);
		eventoDTO.setDataValidade(data);
	}

	@Então("^deve salvar o evento$")
	public void deve_salvar_o_evento() throws Throwable {
		Assert.assertNotNull(eventoCriado.getId());
	}

	@Então("^não deve exibir mensagem de erro$")
	public void não_deve_exibir_mensagem_de_erro() throws Throwable {
		Assert.assertNull(mensagemErro);
	}

	@Dado("^que informo data de validade com valor \"([^\"]*)\"$")
	public void que_informo_data_de_validade_com_valor(String data) throws Throwable {
		Calendar calendar = Calendar.getInstance();
		CalendarUtil.setInicioDia(calendar);
		if ("hoje".equals(data)) {
			eventoDTO.setDataValidade(calendar);
		} else {
			calendar.add(Calendar.DATE, 10);
			eventoDTO.setDataValidade(calendar);
		}
	}
}
