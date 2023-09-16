package com.jsp.person.account;

import java.util.ArrayList;
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
		person.setEmail("abc@mail.com");
		person.setCno(9876541230l);

		Account account1 = new Account();
		account1.setAcc_no(60212455510199l);
		account1.setBank_name("LifeOneBank");
		account1.setIfsc_code("IFSCLOB2455991");
		
		Account account2 = new Account();
		account2.setAcc_no(215498478945154l);
		account2.setBank_name("SBI");
		account2.setIfsc_code("IFSCSBI9142035");
		
		Account account3 = new Account();
		account3.setAcc_no(9876546545231215l);
		account3.setBank_name("HDFC");
		account3.setIfsc_code("IFSCHDFC42342545");

		ArrayList<Account> account=new ArrayList<Account>();
		account.add(account3);
		account.add(account2);
		account.add(account1);
		
		//to set a person with multiple accounts.
		person.setAccount(account);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);

		entityTransaction.commit();

	}

}
