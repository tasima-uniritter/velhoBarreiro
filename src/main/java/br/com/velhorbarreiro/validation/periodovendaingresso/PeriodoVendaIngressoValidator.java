package br.com.velhorbarreiro.validation.periodovendaingresso;

import java.util.List;

import br.com.velhorbarreiro.dto.PeriodoVendaIngressoDTO;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.service.PeriodoVendaIngressoCategoriaIngressoService;

public class PeriodoVendaIngressoValidator {
	public PeriodoVendaIngressoValidator() {
	}

	
	public void validar(PeriodoVendaIngresso periodoVendaIngresso, PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		validarCategoriaExistente(periodoVendaIngresso, periodoVendaIngressoDTO);
	}

	private void validarCategoriaExistente(PeriodoVendaIngresso periodoVendaIngresso,
			PeriodoVendaIngressoDTO periodoVendaIngressoDTO) throws Exception {
		
		PeriodoVendaIngressoCategoriaIngressoService periodoCategoriaService = new PeriodoVendaIngressoCategoriaIngressoService();
		List<PeriodoVendaIngressoCategoriaIngresso> listaPeriodoVendaIngressoCategoria = periodoCategoriaService.lista(periodoVendaIngresso);
		
		if (listaPeriodoVendaIngressoCategoria.stream().anyMatch(
				x -> periodoVendaIngressoDTO.getListaCategoriaIngressoEnum().contains(x.getCategoriaIngressoEnum()))) {
			throw new Exception("Categoria de ingresso ja cadastrado para o periodo de venda.");
		}
	}

}
