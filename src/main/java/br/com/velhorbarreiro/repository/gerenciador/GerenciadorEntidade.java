package br.com.velhorbarreiro.repository.gerenciador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;

public class GerenciadorEntidade {
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public GerenciadorEntidade() {

	}

	public void incluir(Entidade entidade) {
		try {
			// Criar EntityManagerFactory
			emf = Persistence.createEntityManagerFactory("minha-persistence-unit");

			// Criar EntityManager
			em = emf.createEntityManager();

			// Persistir objeto no banco
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			// Fechar EntityManager e EntityManagerFactory
			em.close();
			emf.close();
		}
	}

	public EntityManager getEntityManager() {
			emf = Persistence.createEntityManagerFactory("minha-persistence-unit");
			em = emf.createEntityManager();
			return em;
	}
	
	public void fecharConexao() {
		em.close();
		emf.close();
	}
}
