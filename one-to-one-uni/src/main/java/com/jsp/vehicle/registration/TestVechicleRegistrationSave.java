package com.jsp.vehicle.registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestVechicleRegistrationSave {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setBrand("Ford");
		vehicle.setName("Mustang");
		vehicle.setPrice(11099000);
		
		Registration registration=new Registration();
		registration.setCity("Satara");
		registration.setRegno("MH43YY9875PQR988");
		registration.setVehicle(vehicle);
		
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(registration);
		entityTransaction.commit();
	}

}
