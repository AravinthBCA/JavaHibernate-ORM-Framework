package com.devglan.model;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build(); 
		Metadata md= new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sessionFactory = md.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		
		org.hibernate.Transaction t= session.beginTransaction();
		
		System.out.println("****************Creating Employee*************");
		Employee emp = new Employee("Jhn Doe", 44);
		Phone ph = new Phone();
		ph.setNo("12345678");
		ph.setEmp(emp);
		emp.setPhone(ph);
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		System.out.println("Employee Created Successfully" + emp.toString());
		
	}
	
}
