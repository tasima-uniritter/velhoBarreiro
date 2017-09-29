package br.com.velhorbarreiro.service;

import java.util.List;

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
		repositoryInclusao.inclui(periodoVendaIngressoCategoriaIngresso);

		return periodoVendaIngressoCategoriaIngresso;
	}
	
	public List<PeriodoVendaIngressoCategoriaIngresso> lista(PeriodoVendaIngresso periodoVendaIngresso) {
		PeriodoVendaIngressoCategoriaIngressoRepository repository = new PeriodoVendaIngressoCategoriaIngressoRepository();
		return repository.lista(periodoVendaIngresso);
	}
}
