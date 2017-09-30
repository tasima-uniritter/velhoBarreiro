package br.com.velhorbarreiro.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;

@Entity
public class Evento extends Entidade {

	@Id
	@GeneratedValue
	protected Long id;
	private String nome;
	private Calendar dataValidade;
	
	
	public Long getId() {
		return id;
	}
	
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
