package method_and_constructor;

public class employeesalary {
        
      String name;
      int salary;
      int bonus;
      
      employeesalary(String name, int salary)
      {
    	  this.name = name;
    	  this.salary = salary;
      }
      
      employeesalary(String name, int salary, int bonus)
      {
    	  this.name = name;
    	  this.salary = salary;
    	  this.bonus = bonus;
      }
      
      int totalsalary()
      {
    	  return salary+bonus;
      }
      
      void printdetails() 
      {
    	  System.out.println("Employee name:- " + name);
    	  System.out.println("Employee Salary:- " + salary);
    	  System.out.println("Employee bonus:- " + bonus);
    	  System.out.println("Employee Total salary:- " + totalsalary());
      }
	public static void main(String[] args) {
       
		employeesalary es = new employeesalary("Shubham", 22000);
		employeesalary es1 = new employeesalary("Patil", 18000, 2100);
		es.printdetails();
		es1.printdetails();
	}

}
