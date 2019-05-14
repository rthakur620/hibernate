package com.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOneMaping {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("James");
		student.setCourse("Java");
		
		Branch branch = new Branch();
		branch.setName("Computer Sceince");
		
		student.setBranch(branch);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(branch);
		session.save(student);
		
		
		session.getTransaction().commit();
		session.close();
	}
}
