package br.com.velhorbarreiro.fabrica;

import br.com.velhorbarreiro.builder.BuilderPeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;

public class FabricaPeriodoVendaIngressoDTO {
	private FabricaPeriodoVendaIngressoDTO() {

	}

	public static PeriodoVendaIngressoDTO criar(PeriodoVendaIngresso periodoVendaIngresso) {
		return new BuilderPeriodoVendaIngressoDTO()
				.comId(periodoVendaIngresso.getId())
				.criar();
	}
}
