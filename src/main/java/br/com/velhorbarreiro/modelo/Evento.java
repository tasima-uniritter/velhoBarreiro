package br.com.velhorbarreiro.modelo;

import java.util.Calendar;

public class Evento {
	private String nome;
	private Calendar dataValidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
}
