package com.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestFirstLevelCache {

	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		Student student = new Student();
		student.setId(1);
		student.setName("James");
		student.setCourse("Cloud");
		session.save(student);
		
		Student student1 = session.get(Student.class, 1);
		System.out.println(student1);
		student.setCourse("Big data");
		Student student2 = session.get(Student.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		// Fetching object After second session
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		session2.get(Student.class, 1);
	}
}
