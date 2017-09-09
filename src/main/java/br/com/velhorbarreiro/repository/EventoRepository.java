package br.com.velhorbarreiro.repository;

import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class EventoRepository implements RepositoryInclusao {

	private Evento evento;
	
	public EventoRepository(Evento evento) {
		super();
		this.evento = evento;
	}

	@Override
	public void inclui() {
		GerenciadorEntidade gerenciadorInclusao = new GerenciadorEntidade(this.evento);
		gerenciadorInclusao.incluir();
	}
}
