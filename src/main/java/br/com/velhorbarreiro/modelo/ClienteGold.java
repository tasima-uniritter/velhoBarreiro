package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteGold extends Cliente {
	
	public ClienteGold() {
		super.percentualDesconto = 0.25;
	}
}
