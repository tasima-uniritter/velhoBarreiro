package br.com.velhorbarreiro.builder;

import java.util.Calendar;

import br.com.velhorbarreiro.modelo.Evento;

public class BuilderEvento {
	private Evento evento;

	public BuilderEvento() {
		this.evento = new Evento();
	}

	public BuilderEvento comNome(String nome) {
		this.evento.setNome(nome);
		return this;
	}

	public BuilderEvento paraDataDeValidade(Calendar dataValidade) {
		this.evento.setDataValidade(dataValidade);
		return this;
	}

	public BuilderEvento comValor(Double valor) {
		this.evento.setValor(valor);
		return this;
	}

	public Evento criar() throws Exception {
		evento.validarDados();
		return evento;
	}
}
