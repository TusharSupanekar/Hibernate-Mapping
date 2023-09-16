package com.jsp.person.account;

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
		person.setName("ABC");
		person.setEmail("ABC@mail.com");
		person.setCno(8885556660l);

		Account account1 = new Account();
		account1.setBank_name("UNBOI");
		account1.setAcc_no(11223358478l);
		account1.setIfsc_code("IFSCUNBOI884895");

		Account account2 = new Account();
		account2.setAcc_no(21545895245334l);
		account2.setBank_name("SBI");
		account2.setIfsc_code("IFSCSBI95487856");

		Account account3 = new Account();
		account3.setAcc_no(98556223247855l);
		account3.setBank_name("HDFC");
		account3.setIfsc_code("IFSCHDFC4979855");

		account1.setPerson(person);
		account2.setPerson(person);
		account3.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
		entityTransaction.commit();

	}

}
