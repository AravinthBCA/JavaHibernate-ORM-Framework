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

public class GroupByOperation {

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
			
			String hql = "SELECT SUM(E.age), E.playerName FROM PersistanceClass E " +
		             "GROUP BY E.playerName";
		    Query query = session.createQuery(hql);
		    java.util.List<PersistanceClass> results = query.list();
			System.out.println("Player Details: ");
			for (PersistanceClass p : results) {
				System.out.println(p);
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