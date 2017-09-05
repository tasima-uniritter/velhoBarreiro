package br.com.velhorbarreiro.modelo;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;


public class Evento {
	
	private static final int NUMERO_MAXIMO_CARACTERES = 150;
	
	private String nome;
	private Calendar dataValidade;

	public Evento(String nome, Calendar dataValidade) throws Exception {
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
		if(StringUtils.isBlank(nome)) {
			throw new Exception("Informe o Nome.");
		}
	}
	
	private void validarNomeComNumeroMaximoCaracteres(String nome) throws Exception {
		if(nome.length() > NUMERO_MAXIMO_CARACTERES) {
			throw new Exception("O nome permite no máximo 150 caracteres.");
		}
	}
	
	private void validarDataValidadePreenchida(Calendar dataValidade) throws Exception {
		if(dataValidade == null) {
			throw new Exception("Informe a Data de Validade do Evento.");
		}
	}
}
