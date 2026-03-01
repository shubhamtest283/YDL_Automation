package class_methods_objects;

public class employee {
     String name;
     int salary;
     int bonus;

     void employeedetails(String name, int salary, int bonus) 
     {
    	this.name=name;
    	this.salary=salary;
    	this.bonus=bonus;
    	System.out.println("Employee Name:- " + name); 
    	System.out.println("Employee salary:- " + salary);
    	System.out.println("Employee Bonus:- " + bonus);    	
     }
     void calculatesalary() 
     {
    	 int totalsalary = salary+bonus;
    	 System.out.println("Employee Total Salary:- " + totalsalary);
     }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         employee ep = new employee();
         ep.employeedetails("Shubham", 15000, 3000);;
         ep.calculatesalary();
         
         employee ep1 = new employee();
         ep1.employeedetails("Shubham1", 18000, 5000);;
         ep1.calculatesalary();
         
         employee ep2 = new employee();
         ep2.employeedetails("Shubham2", 12000, 7000);;
         ep2.calculatesalary();
	}

}
