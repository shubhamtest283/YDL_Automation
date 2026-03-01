package class_methods_objects;

public class student_info {
	String name;
	int age;
	double marks;
	
	void printdetails(String name, int age, double marks) 
	{
		this.name = name;
		this.age = age;
		this.marks = marks;
		System.out.println("Student Name:- " + name);
		System.out.println("Student Age:- " + age);
		System.out.println("Student Marks:- " + marks);
		
		if(result() == 1) 
		{
			System.out.println("Student is pass");
		}
		else 
		{
			System.out.println("Student is failed");
		}
	}
	
	int result()
	{
		if(marks >=40) 
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}

	public static void main(String[] args) {
     student_info si = new student_info();
     si.printdetails("Shubham", 29, 30);
     student_info si1 = new student_info();
     si1.printdetails("shubham1", 25, 55.6);
	}

}
