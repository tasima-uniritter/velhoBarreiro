package br.com.velhorbarreiro.fabrica;

import java.util.ArrayList;

import br.com.velhorbarreiro.builder.BuilderPeriodoVendaIngresso;
import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;

public class FabricaPeriodoVendaIngresso {
	private FabricaPeriodoVendaIngresso() {
		
	}
	
	public static PeriodoVendaIngresso criarParaSalvar(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		return new BuilderPeriodoVendaIngresso()
				.comId(periodoVendaIngressoDTO.getId())
				.paraEvento(periodoVendaIngressoDTO.getEvento())
				.comDataInicio(periodoVendaIngressoDTO.getDataInicio())
				.comDataFim(periodoVendaIngressoDTO.getDataFim())
				.comCategoriasDeIngresso(new ArrayList<>())
				.criar();
	}

}
