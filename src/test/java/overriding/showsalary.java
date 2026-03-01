package overriding;

public class showsalary{
		public static void main(String[] args) {
			employeesalary e1 = new permenantemplyee(40000, 3000);
			employeesalary e2 = new contractemployee(1300, 20);
	        System.out.println("permanant employee salary:- " + e1.calculatesalary());
	        System.out.println("permanant employee salary:- " + e2.calculatesalary());
		}
		}