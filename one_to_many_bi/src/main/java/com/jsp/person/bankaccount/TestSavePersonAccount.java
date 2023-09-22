package com.jsp.person.bankaccount;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tushar");

		EntityManager entityManager =
				entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction =
				entityManager.getTransaction();

		Person person = new Person();
		person.setName("ABCD");
		person.setCno(9876543210l);

		Account account1 = new Account();
		account1.setBank_name("HDFC");
		account1.setAccno(65856499884555l);
		account1.setIfsc_code("HDFCNO98740705");

		Account account2 = new Account();
		account2.setBank_name("ICICI");
		account2.setAccno(66498846522333l);
		account2.setIfsc_code("ICICINO44556699");

		Account account3 = new Account();
		account3.setBank_name("AXIS");
		account3.setAccno(69854756686665l);
		account3.setIfsc_code("AXISNO9885544");

		List<Account> account = new ArrayList<Account>();
		account.add(account3);
		account.add(account2);
		account.add(account1);

		person.setAccount(account);

		account1.setPerson(person);
		account2.setPerson(person);
		account3.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();

	}

}
