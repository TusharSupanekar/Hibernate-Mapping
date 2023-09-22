package com.jsp.student.courses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourses {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tushar");

		EntityManager entityManager =
				entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction =
				entityManager.getTransaction();

		Student student = new Student();
		student.setName("XYZ");
		student.setEmail("xyz@mail.com");
		student.setCno(9876543210l);

		Courses course1 = new Courses();
		course1.setCourse_name("Core Java");
		course1.setCourse_duration("2 months");

		Courses course2 = new Courses();
		course2.setCourse_name("Web tech");
		course2.setCourse_duration("1.5 months");

		Courses course3 = new Courses();
		course3.setCourse_name("SQL");
		course3.setCourse_duration("2 months");

		List<Courses> course = new ArrayList<Courses>();
		course.add(course1);
		course.add(course2);
		course.add(course3);

		student.setCourses(course);

		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();

	}

}
