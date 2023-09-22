package com.jsp.bank.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBankBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tushar");
		
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction =
				entityManager.getTransaction();

		Bank bank = new Bank();
		bank.setName("AXIS");

		Branch branch1 = new Branch();
		branch1.setLoc("Vashi");

		Branch branch2 = new Branch();
		branch2.setLoc("Nerul");

		Branch branch3 = new Branch();
		branch3.setLoc("Kharghar");

		Branch branch4 = new Branch();
		branch4.setLoc("Sanpada");

		List<Branch> branch=new ArrayList<Branch>();
		branch.add(branch1);
		branch.add(branch2);
		branch.add(branch3);
		branch.add(branch4);
		
		bank.setBranch(branch);

		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);
		branch4.setBank(bank);
		
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityManager.persist(branch4);
		entityTransaction.commit();

	}

}
