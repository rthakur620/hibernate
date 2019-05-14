package com.hibernate.transPersisDetach;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestTransientPersistentDetached {

	public static void main(String[] args) {
		
		// 1. Transient state of Student object
		Student student = new Student();
		student.setId(1);
		student.setName("James");
		student.setCourse("Cloud");
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		// 2. Persist student state
		session.save(student);
		
		// Put some changes after saving the object
		student.setCourse("BigData");
		
		session.getTransaction().commit();
		session.close();
		// 3. Detached student object from session
		
		student.setCourse("Linux");
	}
}
