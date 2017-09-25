package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteEstudante extends Cliente {

	public ClienteEstudante() {
		super.percentualDesconto = 0.5;
	}
}
