package com.jsp.student.course.with_jointable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("tushar");

		EntityManager entityManager =
				entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction =
				entityManager.getTransaction();

		Student2 student1 = new Student2();
		student1.setName("XYZ");
		student1.setEmail("xyz@mail.com");
		student1.setCno(9876543210l);
		
		Student2 student2 = new Student2();
		student2.setName("ABC");
		student2.setEmail("abc@mail.com");
		student2.setCno(7895463210l);
		
		Student2 student3 = new Student2();
		student3.setName("PQR");
		student3.setEmail("pqr@mail.com");
		student3.setCno(7864523189l);

		Course2 course1 = new Course2();
		course1.setCourse_name("Core Java");
		course1.setCourse_duration("2 months");

		Course2 course2 = new Course2();
		course2.setCourse_name("Web tech");
		course2.setCourse_duration("1.5 months");

		Course2 course3 = new Course2();
		course3.setCourse_name("SQL");
		course3.setCourse_duration("2 months");
		
		List<Course2> course = new ArrayList<Course2>();
		course.add(course1);
		course.add(course2);
		course.add(course3);
		
		List<Student2> student = new ArrayList<Student2>();
		student.add(student1);
		student.add(student2);
		student.add(student3);

		
		student1.setCourses(course);
		student2.setCourses(course);
		student3.setCourses(course);
		
		course1.setStudent(student);
		course2.setStudent(student);
		course3.setStudent(student);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);

		entityTransaction.commit();

	}

}
