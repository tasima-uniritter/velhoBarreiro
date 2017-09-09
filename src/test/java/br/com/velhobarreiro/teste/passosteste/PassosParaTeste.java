package br.com.velhobarreiro.teste.passosteste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PassosParaTeste {
	protected void prepararCenario() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minha-persistence-unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.createQuery(" delete Evento ").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
