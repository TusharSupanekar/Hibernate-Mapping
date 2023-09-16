package com.jsp.hospital.branch;

import java.util.ArrayList;

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

		Hospital hospital = new Hospital();
		hospital.setHospital_name("LifeLine Hospital");
		hospital.setHospital_cno(18009998880l);
		hospital.setCapacity("3000 beds");

		Branch branch1 = new Branch();
		branch1.setBranch_city("Mumbai");
		branch1.setBranch_state("Maharashtra");

		Branch branch2 = new Branch();
		branch2.setBranch_city("Chennai");
		branch2.setBranch_state("Tamil Nadu");

		Branch branch3 = new Branch();
		branch3.setBranch_city("Amritsar");
		branch3.setBranch_state("Punjab");

		ArrayList<Branch> branch = new ArrayList<Branch>();
		branch.add(branch1);
		branch.add(branch2);
		branch.add(branch3);

		hospital.setBranch(branch);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();

	}

}
