package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adopter;

public class AdopterHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SavePuppies");
	
	public void insertAdopter(Adopter a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Adopter> showAllAdopters(){
		EntityManager em = emfactory.createEntityManager();
		List<Adopter> allAdopters = em.createQuery("SELECT a FROM Adopter a").getResultList();
		return allAdopters;
	}
	
	
}
