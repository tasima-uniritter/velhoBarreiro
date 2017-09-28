package br.com.velhobarreiro.teste.ingresso.disponibilizar;

import br.com.velhobarreiro.teste.passosteste.PassosParaTeste;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaDisponibilizarIngresso extends PassosParaTeste {


	@Override
	@Before
	public void prepararCenario() {
		super.prepararCenario();
	}
	
	@Dado("^que seleciono um evento para criar um periodo de venda$")
	public void que_seleciono_um_evento_para_criar_um_periodo_de_venda() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que informa a data de início maior que a data de fim$")
	public void que_informa_a_data_de_início_maior_que_a_data_de_fim() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^salvar o periodo de venda$")
	public void salvar_o_periodo_de_venda() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^deve mostrar a mensagem \"([^\"]*)\"$")
	public void deve_mostrar_a_mensagem(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que tenho um periodo de venda cadastrado com a categoria de ingresso \"([^\"]*)\"$")
	public void que_tenho_um_periodo_de_venda_cadastrado_com_a_categoria_de_ingresso(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que adiciona a categoria \"([^\"]*)\" novamente$")
	public void que_adiciona_a_categoria_novamente(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que seleciono a categoria \"([^\"]*)\"$")
	public void que_seleciono_a_categoria(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que informo valores validos para data final e inicial$")
	public void que_informo_valores_validos_para_data_final_e_inicial() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^deve cadastrar o periodo de venda$")
	public void deve_cadastrar_o_periodo_de_venda() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}	
}
