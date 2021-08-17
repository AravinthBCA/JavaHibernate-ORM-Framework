package SingleTableOperation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionCreation {

	public static void main(String args[])
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		
		 Transaction t=session.beginTransaction();  
	      
		    Employee e1=new Employee();  
		    e1.setFname("Gaurav");  
		    e1.setLname("Chawla");
		      
		    PermanentEmployee e2=new PermanentEmployee();  
		    e2.setFname("Aravinth");
		    e2.setLname("Samy");
		    e2.setSalary(50000);  
		      
		    ContractEmployee e3=new ContractEmployee();  
		    e3.setFname("Arjun");
		    e3.setLname("kumar");
		    e3.setSalary(444224);  
		      
		    session.persist(e1);  
		    session.persist(e2);  
		    session.persist(e3);  
		      
		    t.commit();  
		    session.close();  
		    System.out.println("success");  
		
	}
	
}
