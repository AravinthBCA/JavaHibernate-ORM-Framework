package Basic_Operations;

import java.util.*;

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

public class SelectOperation {

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
			
//			Query query = session.createQuery("from PersistanceClass"); //from statement declare persistance class name only not allow table name.
//          query.setFirstResult(0);  //to fix how many rows you skipped first
//          query.setMaxResults(5);  // to fix how many rows you want
//			java.util.List<PersistanceClass> play= query.list();
//			System.out.println("Player Details: ");
//			for (PersistanceClass p : play) {
//				System.out.println(p);
//			}
			
//			@SuppressWarnings("rawtypes") //not important
	        Query query = session.createQuery("from PersistanceClass");
	        java.util.List<PersistanceClass> list = query.getResultList();
	        System.out.println("Number of Players present--> "+list.size());
	        for (PersistanceClass p: list) {
	            System.out.print(p.getPlayerId()+" ");
	            System.out.print(p.getPlayerName()+" ");
	            System.out.print(p.getAge()+" ");
	            System.out.print(p.getTeamName());
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
