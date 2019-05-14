package com.hibernate.namedquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestNamedQuery {

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
		
		// Query for student by named query 
		Query query = session.getNamedQuery("Student.byId");
		// set argument number and argument value of named query
		query.setInteger(0, 56);
		List<Student> list = (List<Student>)query.list();
		
		// Query for student by native named query 
		Query nativeQuery = session.getNamedQuery("Student.byName");
		// set argument number and argument value of placeholder
		nativeQuery.setString(0, "James");
		List<Student> list2 = (List<Student>)nativeQuery.list();
		
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println("Studnet find by id is :");
		for (Student resultStudent : list) {
			System.out.println(resultStudent);
		}
		
		System.out.println("Studnet find by name is :");
		for (Student resultStudent : list2) {
			System.out.println(resultStudent);
		}
		
		
	}
}
