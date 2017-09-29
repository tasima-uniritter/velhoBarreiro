package br.com.velhorbarreiro.repository;

import javax.persistence.Query;

import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.abstratos.Entidade;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;
import br.com.velhorbarreiro.repository.inteface.RepositoryConsulta;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;

public class PeriodoVendaIngressoRepository implements RepositoryInclusao, RepositoryConsulta {

	@Override 
	public void inclui(Entidade entidade) {
		GerenciadorEntidade gerenciadorInclusao = new GerenciadorEntidade();
		gerenciadorInclusao.incluir(entidade);
	}

	@Override
	public PeriodoVendaIngresso consulta(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select periodo from PeriodoVendaIngresso periodo ");
		sql.append(" left join fetch periodo.listaCategoriaIngresso ");
		sql.append(" where periodo.id = :id ");
		
		GerenciadorEntidade gerenciador = new GerenciadorEntidade();
		Query query = gerenciador.getEntityManager().createQuery(sql.toString());
		query.setParameter("id", id);
		
		PeriodoVendaIngresso periodo = (PeriodoVendaIngresso) query.getSingleResult();
		gerenciador.fecharConexao();
		return periodo;
	}

}
