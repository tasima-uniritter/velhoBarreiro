package br.com.velhorbarreiro.service;

import java.util.ArrayList;
import java.util.List;

import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.fabrica.FabricaPeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.repository.PeriodoVendaIngressoRepository;
import br.com.velhorbarreiro.repository.inteface.RepositoryConsulta;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class PeriodoVendaIngressoService {

	public PeriodoVendaIngressoService() {

	}

	public PeriodoVendaIngresso salvar(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		PeriodoVendaIngresso periodoVendaIngresso = null;
		if (!periodoVendaIngressoDTO.jaPersistido()) {
			periodoVendaIngresso = incluir(periodoVendaIngressoDTO);
		} else {
			RepositoryConsulta rc = new PeriodoVendaIngressoRepository();
			periodoVendaIngresso = (PeriodoVendaIngresso) rc.consulta(periodoVendaIngressoDTO.getId());
			validarCategoriaExistente(periodoVendaIngresso, periodoVendaIngressoDTO);
		}
		List<PeriodoVendaIngressoCategoriaIngresso> listaCategoriasIncluidas = incluirCategoriaDeIngresso(
				periodoVendaIngresso, periodoVendaIngressoDTO.getListaCategoriaIngressoEnum());
		periodoVendaIngresso.getListaCategoriaIngresso().addAll(listaCategoriasIncluidas);
		return periodoVendaIngresso;
	}

	private void validarCategoriaExistente(PeriodoVendaIngresso periodoVendaIngresso,
			PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		
		PeriodoVendaIngressoCategoriaIngressoService periodoCategoriaService = new PeriodoVendaIngressoCategoriaIngressoService();
		List<PeriodoVendaIngressoCategoriaIngresso> listaPeriodoVendaIngressoCategoria = periodoCategoriaService.lista(periodoVendaIngresso);
		
		if (listaPeriodoVendaIngressoCategoria.stream().anyMatch(
				x -> periodoVendaIngressoDTO.getListaCategoriaIngressoEnum().contains(x.getCategoriaIngressoEnum()))) {
			throw new Exception("Categoria de ingresso já cadastrado para o período de venda.");
		}
	}

	private PeriodoVendaIngresso incluir(PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		PeriodoVendaIngresso periodoVendaIngresso = FabricaPeriodoVendaIngresso
				.criarParaSalvar(periodoVendaIngressoDTO);
		RepositoryInclusao repositoryInclusao = new PeriodoVendaIngressoRepository();
		repositoryInclusao.inclui(periodoVendaIngresso);
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
