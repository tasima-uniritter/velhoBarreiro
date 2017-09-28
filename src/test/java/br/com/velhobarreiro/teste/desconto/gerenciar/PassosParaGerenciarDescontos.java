package br.com.velhobarreiro.teste.desconto.gerenciar;

import org.junit.Assert;

import br.com.velhobarreiro.teste.passosteste.PassosParaTeste;
import br.com.velhorbarreiro.modelo.ClienteEstudante;
import br.com.velhorbarreiro.modelo.ClienteGeral;
import br.com.velhorbarreiro.modelo.ClienteGold;
import br.com.velhorbarreiro.modelo.ClienteIdoso;
import br.com.velhorbarreiro.modelo.ClienteSilver;
import br.com.velhorbarreiro.modelo.abstratos.Cliente;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PassosParaGerenciarDescontos extends PassosParaTeste {

	private Cliente cliente;
	private Double valorEvento;

	@Override
	@Before
	public void prepararCenario() {
		super.prepararCenario();
	}
	
	@Dado("^que tenho um cliente do tipo \"([^\"]*)\"$")
	public void que_tenho_um_cliente_do_tipo(String tipoCliente) throws Throwable {
		switch (tipoCliente) {
		case "ClienteEstudante":
			cliente = new ClienteEstudante();
			break;
		case "ClienteIdoso":
			cliente = new ClienteIdoso();
			break;
		case "ClienteGold":
			cliente = new ClienteGold();
			break;
		case "ClienteSilver":
			cliente = new ClienteSilver();
			break;
		default:
			cliente = new ClienteGeral();
		}
	}

	@Dado("^que o valor do ingresso é \"([^\"]*)\" pilas$")
	public void que_o_valor_do_ingresso_é_pilas(Double valorEvento) throws Throwable {
		this.valorEvento = valorEvento;
	}

	@Quando("^calcular o desconto$")
	public void calcular_o_desconto() throws Throwable {
		cliente.calcularDesconto(valorEvento);
	}

	@Então("^o cliente ganhara \"([^\"]*)\"$")
	public void o_cliente_ganhara(String percentualDesconto) throws Throwable {
		Assert.assertEquals(percentualDesconto, cliente.getPercentualDesconto().toString());
	}

	@Então("^o cliente pagara o valor \"([^\"]*)\"$")
	public void o_cliente_pagara_o_valor(String valorPago) throws Throwable {
		Assert.assertEquals(new Double(valorPago), cliente.getValorPago());
	}
}
