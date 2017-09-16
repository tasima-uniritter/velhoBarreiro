package br.com.velhorbarreiro.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;

@Entity
public class Evento extends Entidade {

	private static final int NUMERO_MAXIMO_CARACTERES = 150;

	@Id
	@GeneratedValue
	protected Long id;
	private String nome;
	private Calendar dataValidade;
	private Double valor;
	
	public Evento() {
	
	}
	
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
	
	public void validarDados() throws Exception {
		validarNome();
		validarDataValidade();
	}

	private void validarNome() throws Exception {
		validarNomePreenchido();
		validarNomeComNumeroMaximoCaracteres();
	}

	private void validarDataValidade() throws Exception {
		validarDataValidadePreenchida();
	}

	private void validarNomePreenchido() throws Exception {
		if (StringUtils.isBlank(this.nome)) {
			throw new Exception("Informe o Nome.");
		}
	}

	private void validarNomeComNumeroMaximoCaracteres() throws Exception {
		if (this.nome.length() > NUMERO_MAXIMO_CARACTERES) {
			throw new Exception("O nome permite no máximo 150 caracteres.");
		}
	}

	private void validarDataValidadePreenchida() throws Exception {
		if (this.dataValidade == null) {
			throw new Exception("Informe a Data de Validade do Evento.");
		}
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
