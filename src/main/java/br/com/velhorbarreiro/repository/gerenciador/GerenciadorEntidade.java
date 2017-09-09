package br.com.velhorbarreiro.repository.gerenciador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.velhorbarreiro.modelo.Entidade;

public class GerenciadorEntidade {
	private Entidade entidade;

	public GerenciadorEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public void incluir() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
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
}
