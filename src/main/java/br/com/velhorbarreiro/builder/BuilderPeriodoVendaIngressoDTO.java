package br.com.velhorbarreiro.builder;

import java.util.Calendar;
import java.util.List;

import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.modelo.Evento;

public class BuilderPeriodoVendaIngressoDTO {
	private PeriodoVendaIngressoDTO periodoVendaIngressoDTO;

	public BuilderPeriodoVendaIngressoDTO() {
		this.periodoVendaIngressoDTO = new PeriodoVendaIngressoDTO();
	}

	public BuilderPeriodoVendaIngressoDTO comId(Long id) {
		this.periodoVendaIngressoDTO.setId(id);
		return this;
	}

	public BuilderPeriodoVendaIngressoDTO paraEvento(Evento evento) {
		this.periodoVendaIngressoDTO.setEvento(evento);
		return this;
	}

	public BuilderPeriodoVendaIngressoDTO comDataInicio(Calendar dataInicio) {
		this.periodoVendaIngressoDTO.setDataInicio(dataInicio);
		return this;
	}

	public BuilderPeriodoVendaIngressoDTO comDataFim(Calendar dataFim) {
		this.periodoVendaIngressoDTO.setDataFim(dataFim);
		return this;
	}

	public BuilderPeriodoVendaIngressoDTO paraListaCategoriaIngresso(
			List<CategoriaIngressoEnum> listaCategoriaIngressoEnum) {
		this.periodoVendaIngressoDTO.setListaCategoriaIngressoEnum(listaCategoriaIngressoEnum);
		return this;
	}

	public PeriodoVendaIngressoDTO criar() {
		return this.periodoVendaIngressoDTO;
	}
}
