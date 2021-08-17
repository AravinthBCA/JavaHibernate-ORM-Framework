package ProjectionsOperation;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.query.Query;

import com.mysql.cj.Session;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.mysql.cj.xdevapi.SessionFactory;

import PersistanceClasses.PersistanceClass;
import antlr.collections.List;

public class ProjectionsOperations {

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
			
			//Projection class Methods
			
			Criteria cr = session.createCriteria(PersistanceClass.class);

//			// To get total row count.
//			cr.setProjection(Projections.rowCount());
//
//			// To get average of a property.
//			cr.setProjection(Projections.avg("age"));
//
//			// To get distinct count of a property.
//			cr.setProjection(Projections.countDistinct("playerName"));
//
//			// To get maximum of a property.
//			cr.setProjection(Projections.max(age"));
//
//			// To get minimum of a property.
//			cr.setProjection(Projections.min("age"));

			// To get sum of a property.
			cr.setProjection(Projections.sum("age"));
			
		    java.util.List<PersistanceClass> results = cr.list();
			System.out.println("Player Details: ");
			for (PersistanceClass p : results) {
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
