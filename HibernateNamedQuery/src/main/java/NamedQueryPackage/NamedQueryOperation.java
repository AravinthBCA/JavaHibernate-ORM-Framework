package NamedQueryPackage;

import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.query.Query;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import PersistanceClasses.PersistanceClass;
import antlr.collections.List;

public class NamedQueryOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(PersistanceClasses.PersistanceClass.class);
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties());
			org.hibernate.SessionFactory factory=configuration.buildSessionFactory(builder.build());
			org.hibernate.Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			
			 //Hibernate Named Query    
	        TypedQuery query = session.getNamedQuery("findEmpName");    
	        query.setParameter("name","aravinth");   
	                    
	        java.util.List<PersistanceClass> list=query.getResultList();   
	        for (PersistanceClass obj : list) {
				System.out.print(obj.getId()+" ");
				System.out.print(obj.getJob()+" ");
				System.out.print(obj.getName()+" ");
				System.out.print(obj.getSalary()+" ");
				System.out.println();
			}

			transaction.commit();
			session.close();
		} 
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}	
	}
}
