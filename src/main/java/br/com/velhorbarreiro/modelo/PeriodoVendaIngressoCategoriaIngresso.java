package br.com.velhorbarreiro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.modelo.abstratos.Entidade;

@Entity
public class PeriodoVendaIngressoCategoriaIngresso extends Entidade {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private PeriodoVendaIngresso periodoVendaIngresso;
	private CategoriaIngressoEnum categoriaIngressoEnum;
	
	public PeriodoVendaIngressoCategoriaIngresso() {
		
	}

	public PeriodoVendaIngressoCategoriaIngresso(PeriodoVendaIngresso periodoVendaIngresso,
			CategoriaIngressoEnum categoriaIngressoEnum) {
		super();
		this.periodoVendaIngresso = periodoVendaIngresso;
		this.categoriaIngressoEnum = categoriaIngressoEnum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeriodoVendaIngresso getPeriodoVendaIngresso() {
		return periodoVendaIngresso;
	}

	public void setPeriodoVendaIngresso(PeriodoVendaIngresso periodoVendaIngresso) {
		this.periodoVendaIngresso = periodoVendaIngresso;
	}

	public CategoriaIngressoEnum getCategoriaIngressoEnum() {
		return categoriaIngressoEnum;
	}

	public void setCategoriaIngressoEnum(CategoriaIngressoEnum categoriaIngressoEnum) {
		this.categoriaIngressoEnum = categoriaIngressoEnum;
	}
}
