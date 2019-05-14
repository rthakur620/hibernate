package com.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {

	public static void main(String[] args) {
		// Create one Object
		Student student = new Student();
		student.setName("James");
		student.setCourse("Cloud");
		
		// Create second Object
		Student student2 = new Student();
		student2.setName("Simona");
		student2.setCourse("Spring");
		
		Student student3 = new Student();
		student3.setName("Rahul");
		student3.setCourse("Java");
		
		Student student4 = new Student();
		student4.setName("Govind");
		student4.setCourse("SDN");
		
		// Create session
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student3);
		session.save(student4);
		session.save(student);
		session.save(student2);
		
		// Criteria API for fetching records 
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("name", "James"));
		
		List<Student> list = (List<Student>)criteria.list();
		
		// Criteria API for adding multiple restrictions 
		Criteria criteria2 = session.createCriteria(Student.class);
		criteria2.add(Restrictions.like("name", "%James%"))
				  .add(Restrictions.between("id", 60, 61));
				
		List<Student> list2 = (List<Student>)criteria2.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Criteria 1 result: "+list.get(0));
		System.out.println("Criteria 2 result: "+list2.get(0));
		
	}
}
