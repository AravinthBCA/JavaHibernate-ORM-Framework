package com.devglan.model;

import java.util.Arrays;

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
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	    Session session=factory.openSession();  
	      
	    org.hibernate.Transaction t=session.beginTransaction(); 
		
		System.out.println("****************Creating Department*************");
		Department dept = new Department();
		dept.setName("Science");
		Employee emp1 = new Employee("John", 23);
		emp1.setDept(dept);
		Employee emp2 = new Employee("Rohan", 25);
		emp2.setDept(dept);
		dept.setEmps(Arrays.asList(emp1,emp2));
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		session.close();
		System.out.println("Employee Created Successfully" + dept.toString());
	}

}
