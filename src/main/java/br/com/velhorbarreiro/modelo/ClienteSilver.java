package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteSilver extends Cliente {

	@Override
	public void calcularDesconto(Double valorEvento) {
		super.setValorPago(valorEvento * 0.4);
	}
}
