package br.com.velhorbarreiro.service;

import java.util.ArrayList;
import java.util.List;

import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.fabrica.FabricaPeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;

public class PeriodoVendaIngressoService {

	public PeriodoVendaIngressoService() {

	}

	public PeriodoVendaIngresso salvar(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) {
		PeriodoVendaIngresso periodoVendaIngresso = null;
		if (periodoVendaIngressoDTO.jaPersistido()) {
			periodoVendaIngresso = incluir(periodoVendaIngressoDTO);
		} else {
			//Consultar Periodo
			incluirCategoriaDeIngresso(periodoVendaIngresso, periodoVendaIngressoDTO.getListaCategoriaIngressoEnum());
		}
		return periodoVendaIngresso;
		
	}

	private PeriodoVendaIngresso incluir(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) {
		PeriodoVendaIngresso periodoVendaIngresso = FabricaPeriodoVendaIngresso
				.criarParaIncluir(periodoVendaIngressoDTO);
		GerenciadorEntidade gerenciadorEntidade = new GerenciadorEntidade(periodoVendaIngresso);
		gerenciadorEntidade.incluir();
		return periodoVendaIngresso;
	}

	private List<PeriodoVendaIngressoCategoriaIngresso> incluirCategoriaDeIngresso(
			PeriodoVendaIngresso periodoVendaIngresso, List<CategoriaIngressoEnum> listaCategoriaIngressoEnum) {
		List<PeriodoVendaIngressoCategoriaIngresso> listaPeriodoVendaIngressoCategoriaIngresso = new ArrayList<>();

		PeriodoVendaIngressoCategoriaIngressoService periodoVendaIngressoCategoriaIngressoService = new PeriodoVendaIngressoCategoriaIngressoService();

		for (CategoriaIngressoEnum categoriaIngressoEnum : listaCategoriaIngressoEnum) {
			listaPeriodoVendaIngressoCategoriaIngresso.add(
					periodoVendaIngressoCategoriaIngressoService.incluir(periodoVendaIngresso, categoriaIngressoEnum));
		}

		return listaPeriodoVendaIngressoCategoriaIngresso;
	}

}
