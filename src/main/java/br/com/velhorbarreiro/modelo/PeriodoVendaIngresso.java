package br.com.velhorbarreiro.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;

@Entity
public class PeriodoVendaIngresso extends Entidade {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Evento evento;
	private Calendar dataInicio;
	private Calendar dataFim;
	@OneToMany
	private List<PeriodoVendaIngressoCategoriaIngresso> listaCategoriaIngresso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public List<PeriodoVendaIngressoCategoriaIngresso> getListaCategoriaIngresso() {
		return listaCategoriaIngresso;
	}

	public void setListaCategoriaIngresso(List<PeriodoVendaIngressoCategoriaIngresso> listaCategoriaIngresso) {
		this.listaCategoriaIngresso = listaCategoriaIngresso;
	}

	public boolean possuiEvento() {
		return this.evento != null;
	}

	public boolean possuiDataInicio() {
		return this.dataInicio != null;
	}

	public boolean possuiDataFim() {
		return this.dataFim != null;
	}

}
