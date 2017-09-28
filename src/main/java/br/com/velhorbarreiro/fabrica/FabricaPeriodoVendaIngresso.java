package br.com.velhorbarreiro.fabrica;

import br.com.velhorbarreiro.builder.BuilderPeriodoVendaIngresso;
import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;

public class FabricaPeriodoVendaIngresso {
	private FabricaPeriodoVendaIngresso() {
		
	}
	
	public static PeriodoVendaIngresso criarParaIncluir(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) {
		return new BuilderPeriodoVendaIngresso()
				.paraEvento(periodoVendaIngressoDTO.getEvento())
				.comDataInicio(periodoVendaIngressoDTO.getDataInicio())
				.comDataFim(periodoVendaIngressoDTO.getDataFim())
				.criar();
	}

}
