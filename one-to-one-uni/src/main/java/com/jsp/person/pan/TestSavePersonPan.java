package com.jsp.person.pan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonPan {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
			
		Person person=new Person();
		person.setName("XYZ");
		person.setEmail("xyz@mail.com");
		person.setCno(7898454655l);
		
		Pan pan=new Pan();
		pan.setAddress("Pune");
		pan.setPerson(person); //setting pan with the specified person
		
		entityTransaction.begin();
		entityManager.persist(pan);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}

}
