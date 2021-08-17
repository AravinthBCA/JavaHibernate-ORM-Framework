package LogicalOperation;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.query.Query;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import PersistanceClasses.PersistanceClass;
import antlr.collections.List;

public class LogicalOperations {

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
			
			//Restriction class Methods
			
			Criteria c=session.createCriteria(PersistanceClass.class);  
//		    c.add(Restrictions.gt("age",20));   // GreaterThan
//		    c.add(Restrictions.ge("age",20));   // GreaterThan EqualTo
//		    c.add(Restrictions.lt("age",20));   // LessThan 
//		    c.add(Restrictions.le("age",20));   // LessThan EqualTo
//		    c.add(Restrictions.ne("age",20));   // NotEqual
//		    c.add(Restrictions.eq("age",20));   // Equal  
//		    c.add(Restrictions.between("age",20,30));  // Between Operator

//			// Case sensitive form of the above restriction.
//			c.add(Restrictions.ilike("firstName", "zara%"));
//
//			// To get records having salary in between 1000 and 2000
//			c.add(Restrictions.between("salary", 1000, 2000));
//
//			// To check if the given property is null
//			c.add(Restrictions.isNull("salary"));
//
//			// To check if the given property is not null
//			c.add(Restrictions.isNotNull("salary"));
//
//			// To check if the given property is empty
//			c.add(Restrictions.isEmpty("salary"));
//
//			// To check if the given property is not empty
//			c.add(Restrictions.isNotEmpty("salary"));
			
//			Criterion salary = Restrictions.gt("salary", 2000);
//			Criterion name = Restrictions.ilike("firstNname","zara%");
//
//			// To get records matching with OR conditions
//			LogicalExpression orExp = Restrictions.or(salary, name);
//			c.add( orExp );
//
//			// To get records matching with AND conditions
//			LogicalExpression andExp = Restrictions.and(salary, name);
//			c.add( andExp );
			
		    c.add(Restrictions.like("playerName","R%")); // Like Operator   
		    
			java.util.List<PersistanceClass> results = c.list();
			System.out.println("Player Details: ");
			for (PersistanceClass p : results) {
				System.out.print(p.getPlayerId()+" ");
				System.out.print(p.getPlayerName()+" ");
				System.out.print(p.getAge()+" ");
				System.out.print(p.getTeamName());
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
