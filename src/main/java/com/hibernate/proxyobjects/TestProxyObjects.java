package com.hibernate.proxyobjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestProxyObjects {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("James");
		student.setCourse("GoLang");
		
		Address address = new Address();
		address.setCity("Gurgaon");
		address.setState("Haryana");
		address.setStreet("123");
		
		student.getListOfAddress().add(address);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		/*session.save(student);*/
		
		session.getTransaction().commit();
		session.close();
		
		session= sessionFactory.openSession();
		session.beginTransaction();
		
		Student student2  = (Student)session.get(Student.class, 22);
		System.out.println(student2.getCourse());
		session.close();
		System.out.println(student2.getListOfAddress().size());
	}
}
