package br.com.velhorbarreiro.builder;

import java.util.Calendar;
import java.util.List;

import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;

public class BuilderPeriodoVendaIngresso {
	private PeriodoVendaIngresso periodoVendaIngresso;

	public BuilderPeriodoVendaIngresso() {
		this.periodoVendaIngresso = new PeriodoVendaIngresso();
	}

	public BuilderPeriodoVendaIngresso paraEvento(Evento evento) {
		this.periodoVendaIngresso.setEvento(evento);
		return this;
	}

	public BuilderPeriodoVendaIngresso comDataInicio(Calendar dataInicio) {
		this.periodoVendaIngresso.setDataInicio(dataInicio);
		return this;
	}

	public BuilderPeriodoVendaIngresso comDataFim(Calendar dataFim) {
		this.periodoVendaIngresso.setDataFim(dataFim);
		return this;
	}

	public BuilderPeriodoVendaIngresso paraAsCategoriasDeIngresso(
			List<PeriodoVendaIngressoCategoriaIngresso> listaCategoriaIngresso) {
		this.periodoVendaIngresso.setListaCategoriaIngresso(listaCategoriaIngresso);
		return this;
	}

	public PeriodoVendaIngresso criar() {
		return this.periodoVendaIngresso;
	}
}
