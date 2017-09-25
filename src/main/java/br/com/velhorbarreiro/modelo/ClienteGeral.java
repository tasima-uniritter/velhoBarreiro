package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteGeral extends Cliente {
	
	public ClienteGeral() {
		super.percentualDesconto = 1.0;
	}
}
