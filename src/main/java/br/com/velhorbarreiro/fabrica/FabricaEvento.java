package br.com.velhorbarreiro.fabrica;

import java.util.Calendar;

import br.com.velhorbarreiro.builder.BuilderEvento;
import br.com.velhorbarreiro.modelo.Evento;

public class FabricaEvento {

	private FabricaEvento() {
		
	}
	
	public static Evento criar(String nome, Calendar dataValidade) throws Exception {
		return new BuilderEvento()
				.comNome(nome)
				.paraDataDeValidade(dataValidade)
				.criar();
	}
}
