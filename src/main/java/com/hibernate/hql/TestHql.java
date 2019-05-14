package com.hibernate.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHql {

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
		
		/*session.save(student3);
		session.save(student4);
		session.save(student);
		session.save(student2);*/
		
		// Query for fetching all the records 
		Query query = session.createQuery("from StudentHql");
		
		
		
		// Query for fetching a single record
		Query query2 = session.createQuery("from Student where name='Simona'");
		
		
		// Query for fetching a set of record (Used in Pagination) 
		Query query3 = session.createQuery("from Student");
		query3.setFirstResult(2); // From which record
		query3.setMaxResults(3);  // How many records
		
		
		// Query for fetching all the records 
		Query query4 = session.createQuery("select name from Student");
		
		
		session.getTransaction().commit();
		List list = query.list();
		List list2 = query2.list();
		List list3 = query3.list();
		List<String> list4 = (List<String>) query4.list();
		
		session.close();
		
		System.out.println("List1 size: "+list.size());
		System.out.println("List2 size: "+list2.size());
		System.out.println("List3 size: "+list3.size());
		System.out.println("List all Students");
		for (String student5 : list4) {
			System.out.println(student);
		}
	}
}
