package com.jsp.hospital.branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tushar");
		
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction =
				entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setHospital_name("CityLifeHospital");
		hospital.setHospital_cno(1800555999);
		hospital.setCapacity("2500 beds");
		
		Branch branch1=new Branch();
		branch1.setBranch_city("Mumbai");
		branch1.setBranch_state("Maharashtra");

		Branch branch2=new Branch();
		branch2.setBranch_city("Vadora");
		branch2.setBranch_state("Gujarat");
		
		Branch branch3=new Branch();
		branch3.setBranch_city("Lucknow");
		branch3.setBranch_state("Uttar Pradesh");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();

		


		

	}

}
