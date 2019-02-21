package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AdoptionDetails;

public class AdoptionDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SavePuppies");
	
	public void insertNewAdoptionDetails(AdoptionDetails a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AdoptionDetails> getAdoptions(){
		EntityManager em = emfactory.createEntityManager();
		List<AdoptionDetails> allDetails = em.createQuery("SELECT d FROM AdoptionDetails d").getResultList();
		return allDetails;
	}
	
	
}
