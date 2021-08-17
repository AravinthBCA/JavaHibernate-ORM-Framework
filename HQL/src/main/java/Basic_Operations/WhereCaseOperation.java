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

public class WhereCaseOperation {

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
			
//			Query query = session.createQuery("from PersistanceClass where playerName=:name"); //from statement declare persistance class name only not allow table name.
//			query.setString("name","Arav");
//			Query query = session.createQuery("from PersistanceClass where teamName=:name");
//			query.setString("name","India");
//			Query query = session.createQuery("from PersistanceClass where age=:age order by playerName desc");
//			query.setInteger("age",30);
			Query query = session.createQuery("from PersistanceClass where age between :age1 and :age2 order by playerName desc");
			query.setInteger("age1",25);
			query.setInteger("age2",30);
			java.util.List<PersistanceClass> play= query.list();
			System.out.println("Player Details: ");
			for (PersistanceClass p : play) {
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
