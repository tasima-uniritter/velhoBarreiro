package br.com.velhobarreiro.teste.ingresso.disponibilizar;

import java.util.Calendar;

import org.junit.Assert;

import br.com.velhobarreiro.teste.desconto.dataprovider.EventoDataProvider;
import br.com.velhobarreiro.teste.desconto.dataprovider.PeriodoVendaIngressoDataProvider;
import br.com.velhobarreiro.teste.passosteste.PassosParaTeste;
import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.fabrica.FabricaPeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.service.PeriodoVendaIngressoService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaDisponibilizarIngresso extends PassosParaTeste {

	private PeriodoVendaIngressoDTO periodoVendaIngressoDTO = new PeriodoVendaIngressoDTO();
	private EventoDataProvider eventoDataProvider = new EventoDataProvider();
	private PeriodoVendaIngressoDataProvider periodoVendaIngressoDataProvider = new PeriodoVendaIngressoDataProvider();
	private String mensagemExcecao;
	private PeriodoVendaIngresso periodoVendaIngressoIncluido;

	@Override
	@Before
	public void prepararCenario() {
		super.prepararCenario();
	}

	@Dado("^que seleciono um evento para criar um periodo de venda$")
	public void que_seleciono_um_evento_para_criar_um_periodo_de_venda() throws Throwable {
		periodoVendaIngressoDTO.setEvento(eventoDataProvider.criar());
	}

	@Dado("^que informo a data de incio maior que a data de fim$")
	public void que_informa_a_data_de_inicio_maior_que_a_data_de_fim() throws Throwable {
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.add(Calendar.DATE, 10);

		Calendar dataFim = Calendar.getInstance();

		periodoVendaIngressoDTO.setDataFim(dataFim);
		periodoVendaIngressoDTO.setDataInicio(dataInicio);
	}

	@Quando("^salvar o periodo de venda$")
	public void salvar_o_periodo_de_venda() throws Throwable {
		try {
			PeriodoVendaIngressoService service = new PeriodoVendaIngressoService();
			periodoVendaIngressoIncluido = service.salvar(periodoVendaIngressoDTO);
		} catch (Exception e) {
			mensagemExcecao = e.getMessage();
		}
	}

	@Entao("^deve mostrar a mensagem \"([^\"]*)\"$")
	public void deve_mostrar_a_mensagem(String mensagemEsperada) throws Throwable {
		Assert.assertEquals(mensagemEsperada, mensagemExcecao);
	}

	@Dado("^que tenho um periodo de venda cadastrado com a categoria de ingresso \"([^\"]*)\"$")
	public void que_tenho_um_periodo_de_venda_cadastrado_com_a_categoria_de_ingresso(CategoriaIngressoEnum categoriaIngressoEnum) throws Throwable {
		PeriodoVendaIngresso periodoVendaIngresso = periodoVendaIngressoDataProvider.criar(categoriaIngressoEnum);
		periodoVendaIngressoDTO = FabricaPeriodoVendaIngressoDTO.criar(periodoVendaIngresso);
	}

	@Dado("^que adiciona a categoria \"([^\"]*)\" novamente$")
	public void que_adiciona_a_categoria_novamente(CategoriaIngressoEnum categoriaIngressoEnum) throws Throwable {
		periodoVendaIngressoDTO.getListaCategoriaIngressoEnum().add(categoriaIngressoEnum);
	}

	@Dado("^que seleciono a categoria \"([^\"]*)\"$")
	public void que_seleciono_a_categoria(CategoriaIngressoEnum categoriaIngressoEnum) throws Throwable {
		periodoVendaIngressoDTO.getListaCategoriaIngressoEnum().add(categoriaIngressoEnum);
	}
	
	@Dado("^que nao seleciono nenhum evento$")
	public void que_nao_seleciono_nenhum_evento() throws Throwable {
	    periodoVendaIngressoDTO.setEvento(null);
	}

	@Dado("^que informo a data de inicio e fim com valores validos$")
	public void que_informa_a_data_de_inicio_e_fim_com_valores_validos() throws Throwable {
		Calendar dataFim = Calendar.getInstance();
		dataFim.add(Calendar.DATE, 10);

		Calendar dataInicio = Calendar.getInstance();

		periodoVendaIngressoDTO.setDataFim(dataFim);
		periodoVendaIngressoDTO.setDataInicio(dataInicio);
	}

	@Dado("^que nao informo data de inicio$")
	public void que_nao_informo_data_de_inicio() throws Throwable {
	    periodoVendaIngressoDTO.setDataInicio(null);
	}

	@Dado("^que informo data de fim$")
	public void que_informo_data_de_fim() throws Throwable {
	   periodoVendaIngressoDTO.setDataFim(Calendar.getInstance());
	}

	@Dado("^que nao informo data de fim$")
	public void que_nao_informo_data_de_fim() throws Throwable {
	   periodoVendaIngressoDTO.setDataFim(null);
	}

	@Dado("^que informo data de inicio$")
	public void que_informo_data_de_inicio() throws Throwable {
	    periodoVendaIngressoDTO.setDataInicio(Calendar.getInstance());
	}

	@Dado("^que nao seleciono nenhuma categoria de ingresso$")
	public void que_nao_seleciono_nenhuma_categoria_de_ingresso() throws Throwable {
	    //não faz nada nesse passo
	}

	@Entao("^o periodo de venda e salvo$")
	public void o_periodo_de_venda_e_salvo() throws Throwable {
	    Assert.assertNotNull(periodoVendaIngressoIncluido);
	}

	@Entao("^a categoria de ingresso foi associada$")
	public void a_categoria_de_ingresso_foi_associada() throws Throwable {
	    Assert.assertFalse(periodoVendaIngressoIncluido.getListaCategoriaIngresso().isEmpty());
	}

}
