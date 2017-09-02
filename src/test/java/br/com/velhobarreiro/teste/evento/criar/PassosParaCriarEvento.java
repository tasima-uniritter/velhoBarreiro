package br.com.velhobarreiro.teste.evento.criar;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.BeforeClass;

import br.com.velhorbarreiro.evento.EventoRN;
import br.com.velhorbarreiro.modelo.Evento;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PassosParaCriarEvento {

	private Evento evento;

	private EventoRN eventoRN;

	private String mensagemErro;

	@Dado("^que quero criar um evento$")
	public void que_quero_criar_um_evento() throws Throwable {
		eventoRN = new EventoRN();
		evento = new Evento();
	}

	@Dado("^que não informo o nome$")
	public void que_não_informo_o_nome() throws Throwable {
		evento.setNome(null);
	}

	@Dado("^que informo data de validade$")
	public void que_informo_data_de_validade() throws Throwable {
		evento.setDataValidade(Calendar.getInstance());
	}

	@Quando("^salvar o evento$")
	public void salvar_o_evento() throws Throwable {
		try {
			eventoRN.criar(evento);
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
		evento.setDataValidade(null);
	}

	@Dado("^que informo o nome$")
	public void que_informo_o_nome() throws Throwable {
		evento.setNome("final");
	}

	@Dado("^que informo um nome com mais de (\\d+) caracteres$")
	public void que_informo_um_nome_com_mais_de_caracteres(int numeroMaximoCaracteres) throws Throwable {
		StringBuilder builderNome = new StringBuilder();
		for (int i = 0; i <= numeroMaximoCaracteres; i++) {
			builderNome.append("a");
		}
		evento.setNome(builderNome.toString());
	}

	@Então("^deve exibir a mensagem \"(.*?)\"$")
	public void deve_exibir_a_mensagem(String menssagemEsperada) throws Throwable {
		Assert.assertEquals(menssagemEsperada, mensagemErro);
	}

	@Dado("^informo uma data de validade menor que a data atual$")
	public void informo_uma_data_de_validade_menor_que_a_data_atual() throws Throwable {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, -1);
		evento.setDataValidade(data);
	}

	@Então("^deve salvar o evento$")
	public void deve_salvar_o_evento() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Então("^não deve exibir mensagem de erro$")
	public void não_deve_exibir_mensagem_de_erro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
