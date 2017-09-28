package br.com.velhorbarreiro.service;

import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.repository.PeriodoVendaIngressoCategoriaIngressoRepository;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class PeriodoVendaIngressoCategoriaIngressoService {

	public PeriodoVendaIngressoCategoriaIngressoService() {

	}

	public PeriodoVendaIngressoCategoriaIngresso incluir(PeriodoVendaIngresso periodoVendaIngresso,
			CategoriaIngressoEnum categoriaIngressoEnum) {

		PeriodoVendaIngressoCategoriaIngresso periodoVendaIngressoCategoriaIngresso = new PeriodoVendaIngressoCategoriaIngresso(
				periodoVendaIngresso, categoriaIngressoEnum);

		RepositoryInclusao repositoryInclusao = new PeriodoVendaIngressoCategoriaIngressoRepository();
		repositoryInclusao.inclui(periodoVendaIngresso);

		return periodoVendaIngressoCategoriaIngresso;
	}
}
