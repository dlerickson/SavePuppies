package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListPuppers;

public class ListPuppersHelper {
//Don Erickson
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SavePuppies");
	
	//accept more pups to foster(and maybe keep :))!
	public void fosterPups(ListPuppers lp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lp);
		em.getTransaction().commit();
		em.close();
	}
	
	//create list of all puppies past and present
	public List<ListPuppers> showMeThePuppy(){
		EntityManager em = emfactory.createEntityManager();
		List<ListPuppers> thePuppies = em.createQuery("SELECT p FROM ListPuppers p").getResultList();
		return thePuppies;
	}
	
	//pet the dooogs bye
	public void deletePups(ListPuppers toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPuppers> typedQuery = em.createQuery("select lp from ListPuppers lp where lp.name = :selectedName"
				+ " and lp.favToy =:selectedFavToy and lp.status = :selectedStatus", ListPuppers.class);
		
		//subbing param w/ treats from directly above^^^
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedFavToy", toDelete.getFavToy());
		typedQuery.setParameter("selectedStatus", toDelete.getStatus());
		
		//I can only say bye to one pup at a time
		typedQuery.setMaxResults(1);
		
		//get result of saying bye to deleted dog-o
		ListPuppers result = typedQuery.getSingleResult();
		
		//clean up after dog-o leaves
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public ListPuppers searchForPupById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListPuppers cuddle = em.find(ListPuppers.class, idToEdit);
		em.close();
		return cuddle;
	}

	//sends the changes to pups info back to database to update
	public void updateGoodDoggie(ListPuppers toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<ListPuppers> searchForPupByName(String dogName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPuppers> typedQuery = em.createQuery("SELECT lp FROM ListPuppers lp WHERE lp.name = :selectedName", ListPuppers.class);
		typedQuery.setParameter("selectedName",dogName);
		
		List<ListPuppers> foundPups = typedQuery.getResultList();
		em.close();
		return foundPups;
	}

	public List<ListPuppers> searchForPupByStatus(String dogStatus) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPuppers> typedQuery = em.createQuery("SELECT lp FROM ListPuppers lp WHERE lp.status = :selectedStatus", ListPuppers.class);
		typedQuery.setParameter("selectedStatus",dogStatus);
		
		List<ListPuppers> foundPups = typedQuery.getResultList();
		em.close();
		return foundPups;
	}
	
	//Shut down the EntityManagerFactory and more importantly shut down puppy factories. Adopt!
	public void cleanUp() {
		emfactory.close();
	}
	
}
