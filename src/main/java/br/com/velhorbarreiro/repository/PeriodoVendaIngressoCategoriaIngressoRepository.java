package br.com.velhorbarreiro.repository;

import java.util.List;

import javax.persistence.Query;

import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.modelo.abstratos.Entidade;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class PeriodoVendaIngressoCategoriaIngressoRepository implements RepositoryInclusao {

	@Override
	public void inclui(Entidade entidade) {
		GerenciadorEntidade gerenciadorInclusao = new GerenciadorEntidade();
		gerenciadorInclusao.incluir(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<PeriodoVendaIngressoCategoriaIngresso> lista(PeriodoVendaIngresso periodoVendaIngresso) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select periodoCategoria from PeriodoVendaIngressoCategoriaIngresso periodoCategoria ");
		sql.append(" where periodoCategoria.periodoVendaIngresso = :periodoVendaIngresso");
		
		GerenciadorEntidade gerenciador = new GerenciadorEntidade();
		Query query = gerenciador.getEntityManager().createQuery(sql.toString());
		query.setParameter("periodoVendaIngresso", periodoVendaIngresso);
		
		return query.getResultList();
	}

}
