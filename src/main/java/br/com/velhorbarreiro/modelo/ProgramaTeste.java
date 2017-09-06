package br.com.velhorbarreiro.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramaTeste {

	public static void main(String[] args) throws Exception {
		// Criar EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minha-persistence-unit");

		// Criar EntityManager
		EntityManager em = emf.createEntityManager();
		        
		// Fazer consulta ao banco
		List<Evento> lista = em.createQuery("FROM Evento", Evento.class).getResultList();
		
		for (Evento evento : lista) {
			System.out.println(evento.getId() + " " + evento.getNome());
		}
		
		Evento objeto = new Evento("123", Calendar.getInstance());
		        
		// Persistir objeto no banco
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
		        
		// Fechar EntityManager e EntityManagerFactory
		em.close();
		emf.close();

	}

}
