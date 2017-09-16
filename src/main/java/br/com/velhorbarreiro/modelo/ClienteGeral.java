package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteGeral extends Cliente {

	@Override
	public void calcularDesconto(Double valorEvento) {
		super.setValorPago(valorEvento * 1);
	}
}
