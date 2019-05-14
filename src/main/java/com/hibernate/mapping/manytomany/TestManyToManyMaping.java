package com.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestManyToManyMaping {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("James");
		student.setCourse("Java");
		
		Branch branch = new Branch();
		branch.setName("Mechanical");
		
		Branch branch2 = new Branch();
		branch2.setName("Computer Science");
		
		student.getBranch().add(branch);
		student.getBranch().add(branch2);
		
		branch.getStudents().add(student);
		branch2.getStudents().add(student);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.save(branch);
		session.save(branch2);
		
		session.getTransaction().commit();
		session.close();
	}
}
