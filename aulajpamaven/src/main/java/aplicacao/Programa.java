package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Luiz Carlos da Silva", "luizcarlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Marcio Rodrigues", "marcio@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Beatriz", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("pronto");
		
		em.close();
		emf.close();
		
	}

}
