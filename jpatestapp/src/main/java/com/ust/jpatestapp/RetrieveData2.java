package com.ust.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.ust.jpatestapp.dto.Movies;

public class RetrieveData2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction trans = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");         //Persistence stage....It connects to database
			em = emf.createEntityManager();                                          //Persistence stage....It connects to database
			trans = em.getTransaction();
			trans.begin();
			
			//Movies m = em.find(Movies.class, 3);
			
			Movies m = em.getReference(Movies.class, 3);               //Transient stage....because we are making object and this object is not connected to database
			System.out.println(m.getId());
			System.out.println(m.getName());
			System.out.println(m.getRating());
			System.out.println(m.getClass());
			
			System.out.println(em.contains(m));
			em.detach(m);                                             //Detach Stage....It detaches the object from EntityManager
			System.out.println(em.contains(m));                       //This is for checking purpose that object is detached or not

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
