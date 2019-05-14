package com.hibernate.inheritanceTablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestInheritanceTablePerClass {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclaName("car");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehiclaName("Bike");
		twoWheeler.setSteeringHandle("Bike steering handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehiclaName("Porche");
		fourWheeler.setSteeringWheel("Porche Steering wheel");
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session  session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
