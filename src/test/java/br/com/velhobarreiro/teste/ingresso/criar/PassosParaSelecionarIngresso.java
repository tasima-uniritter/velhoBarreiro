package br.com.velhobarreiro.teste.ingresso.criar;

import org.junit.Assert;

import br.com.velhobarreiro.teste.passosteste.PassosParaTeste;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaSelecionarIngresso extends PassosParaTeste {

	private CategoriaIngressoEnum categoriaIngressoEnum;
	private String descricaoCategoriaIngresso;

	@Override
	@Before
	public void prepararCenario() {
		super.prepararCenario();
	}

	@Dado("^que sou gestor do evento$")
	public void que_sou_gestor_do_evento() throws Throwable {
		//
	}

	@Dado("^que quero disponibilizar um ingresso \"([^\"]*)\"$")
	public void que_quero_disponibilizar_um_ingresso(String descricaoCategoriaIngresso) throws Throwable {
		this.descricaoCategoriaIngresso = descricaoCategoriaIngresso;
	}

	@Quando("^selecionar o ingresso$")
	public void selecionar_o_ingresso() throws Throwable {
		categoriaIngressoEnum = CategoriaIngressoEnum.valueOf(descricaoCategoriaIngresso);
	}

	@Entao("^o mesmo deve ter o valor \"([^\"]*)\"$")
	public void o_mesmo_deve_ter_o_valor(Double valor) throws Throwable {
		Assert.assertEquals(valor, categoriaIngressoEnum.getValor());
	}
}
