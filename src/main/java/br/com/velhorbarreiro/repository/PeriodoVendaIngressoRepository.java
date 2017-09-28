package br.com.velhorbarreiro.repository;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class PeriodoVendaIngressoRepository implements RepositoryInclusao {

	@Override
	public void inclui(Entidade entidade) {
		GerenciadorEntidade gerenciadorInclusao = new GerenciadorEntidade(entidade);
		gerenciadorInclusao.incluir();
	}

}
