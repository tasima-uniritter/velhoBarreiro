package br.com.velhobarreiro.teste.desconto.dataprovider;

import java.util.Calendar;

import br.com.velhorbarreiro.builder.BuilderEvento;
import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;

public class EventoDataProvider {

	public Evento criar() throws Exception {
		Evento evento = new BuilderEvento()
				.comDataDeValidade(Calendar.getInstance())
				.comNome("EVENTO")
				.criar();
		
		GerenciadorEntidade ge = new GerenciadorEntidade();
		ge.incluir(evento);
		
		
		return evento;
	}
}
