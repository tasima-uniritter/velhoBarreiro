package br.com.velhorbarreiro.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.modelo.Evento;

public class PeriodoVendaIngressoDTO {

	private Long id;
	private Calendar dataInicio;
	private Calendar dataFim;
	private Evento evento;
	private List<CategoriaIngressoEnum> listaCategoriaIngressoEnum;
	
	public PeriodoVendaIngressoDTO() {
		this.listaCategoriaIngressoEnum = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<CategoriaIngressoEnum> getListaCategoriaIngressoEnum() {
		return listaCategoriaIngressoEnum;
	}

	public void setListaCategoriaIngressoEnum(List<CategoriaIngressoEnum> listaCategoriaIngressoEnum) {
		this.listaCategoriaIngressoEnum = listaCategoriaIngressoEnum;
	}

	public boolean jaPersistido() {
		return id != null && id > 0;
	}

}
