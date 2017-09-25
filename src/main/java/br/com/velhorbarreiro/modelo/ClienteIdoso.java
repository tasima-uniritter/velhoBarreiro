package br.com.velhorbarreiro.modelo;

import br.com.velhorbarreiro.modelo.abstratos.Cliente;

public class ClienteIdoso extends Cliente { 
	
	public ClienteIdoso() {
		super.percentualDesconto = 0.5;
	}
}
