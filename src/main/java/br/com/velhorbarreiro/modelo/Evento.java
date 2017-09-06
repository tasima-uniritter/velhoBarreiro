package br.com.velhorbarreiro.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

@Entity
public class Evento {

	private static final int NUMERO_MAXIMO_CARACTERES = 150;

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Calendar dataValidade;
	
	private Evento() {
	}

	public Evento(String nome, Calendar dataValidade) throws Exception {
		this();
		validarNome(nome);
		validarDataValidade(dataValidade);
		this.nome = nome;
		this.dataValidade = dataValidade;
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

	private void validarNome(String nome) throws Exception {
		validarNomePreenchido(nome);
		validarNomeComNumeroMaximoCaracteres(nome);
	}

	private void validarDataValidade(Calendar dataValidade) throws Exception {
		validarDataValidadePreenchida(dataValidade);
	}

	private void validarNomePreenchido(String nome) throws Exception {
		if (StringUtils.isBlank(nome)) {
			throw new Exception("Informe o Nome.");
		}
	}

	private void validarNomeComNumeroMaximoCaracteres(String nome) throws Exception {
		if (nome.length() > NUMERO_MAXIMO_CARACTERES) {
			throw new Exception("O nome permite no máximo 150 caracteres.");
		}
	}

	private void validarDataValidadePreenchida(Calendar dataValidade) throws Exception {
		if (dataValidade == null) {
			throw new Exception("Informe a Data de Validade do Evento.");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
