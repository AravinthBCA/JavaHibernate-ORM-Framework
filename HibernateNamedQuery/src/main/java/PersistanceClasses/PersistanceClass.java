package PersistanceClasses;
  

import javax.persistence.*;  
  
@NamedQueries(  
    {  
        @NamedQuery(  
        name = "findEmpName",  
        query = "from PersistanceClass e where e.name = :name"  
        )  
    }  
)  
  
@Entity  
@Table(name="NamedQuery_Table")  
public class PersistanceClass {  
    
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // Auto Increment
    int id;  
    String name;  
    int salary;  
    String job;  

   //getters and setters  
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	//toString inbuild Method
	
	public String toString(){return id+" "+name+" "+salary+" "+job;}
       
	
}  