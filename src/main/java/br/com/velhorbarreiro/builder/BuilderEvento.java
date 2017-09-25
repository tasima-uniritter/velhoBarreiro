package br.com.velhorbarreiro.builder;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import br.com.velhorbarreiro.modelo.Evento;

public class BuilderEvento {
	
	private static final int NUMERO_MAXIMO_CARACTERES = 150;
	
	private Evento evento;

	public BuilderEvento() {
		this.evento = new Evento();
	}

	public BuilderEvento comNome(String nome) throws Exception {
		validarNome(nome);
		this.evento.setNome(nome);
		return this;
	}

	public BuilderEvento comDataDeValidade(Calendar dataValidade) throws Exception {
		validarDataValidade(dataValidade);
		this.evento.setDataValidade(dataValidade);
		return this;
	}

	public Evento criar() {
		return evento;
	}
	
	//--------------- Privados
	
	private void validarNome(String nome) throws Exception {
		validarNomePreenchido(nome);
		validarNomeComNumeroMaximoCaracteres(nome);
	}
	
	private void validarNomePreenchido(String nome) throws Exception {
		if (StringUtils.isBlank(nome)) {
			throw new Exception("Informe o Nome.");
		}
	}

	private void validarNomeComNumeroMaximoCaracteres(String nome) throws Exception {
		if (nome.length() > NUMERO_MAXIMO_CARACTERES) {
			throw new Exception("O nome permite no máximo " + NUMERO_MAXIMO_CARACTERES + " caracteres.");
		}
	}
	
	private void validarDataValidade(Calendar dataValidade) throws Exception {
		validarDataValidadePreenchida(dataValidade);
	}
	
	private void validarDataValidadePreenchida(Calendar dataValidade) throws Exception {
		if (dataValidade == null) {
			throw new Exception("Informe a Data de Validade do Evento.");
		}
	}
}
