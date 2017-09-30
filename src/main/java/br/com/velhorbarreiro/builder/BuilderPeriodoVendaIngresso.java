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

	public BuilderPeriodoVendaIngresso comId(Long id) {
		this.periodoVendaIngresso.setId(id);
		return this;
	}
	
	public BuilderPeriodoVendaIngresso comCategoriasDeIngresso(List<PeriodoVendaIngressoCategoriaIngresso> listaCategoriaIngresso) {
		this.periodoVendaIngresso.setListaCategoriaIngresso(listaCategoriaIngresso);
		return this;
	}
	
	public PeriodoVendaIngresso criar() throws Exception {
		validarEventoSelecionado();
		validarDataInicioPreenchida();
		validarDataFimlPreenchida();
		validarDataInicioAnteriorDataFim();
		return this.periodoVendaIngresso;
	}

	private void validarEventoSelecionado() throws Exception {
		if (!this.periodoVendaIngresso.possuiEvento()) {
			throw new Exception("Informe o evento.");
		}
	}

	private void validarDataInicioPreenchida() throws Exception {
		if (!this.periodoVendaIngresso.possuiDataInicio()) {
			throw new Exception("Informe a data de inicio.");
		}
	}

	private void validarDataFimlPreenchida() throws Exception {
		if (!this.periodoVendaIngresso.possuiDataFim()) {
			throw new Exception("Informe a data de fim.");
		}
	}

	private void validarDataInicioAnteriorDataFim() throws Exception {
		Calendar dataInicio = this.periodoVendaIngresso.getDataInicio();
		Calendar dataFim = this.periodoVendaIngresso.getDataFim();
		if (dataFim.before(dataInicio)) {
			throw new Exception("A data de inicio de venda deve ser inferior a data de fim.");
		}
	}

}
