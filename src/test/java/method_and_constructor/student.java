package method_and_constructor;
public class student {
	String name;
	int age;
	double marks;
	student(String name, int age, double marks)
	{
		this.name = name;
		this.age = age;
		this.marks = marks;
		if(printdetails() == true)
		{
		    System.out.println("eligible");
		}
		else 
		{
			System.out.println("not eligible");
		}		
	}	
	boolean printdetails()
	{
		   System.out.println("Student Name Is:- " + name);	
		   System.out.println("Student Age Is:- " + age);
		   System.out.println("Student Marks Is:- " + marks);
	   if(marks>=18) 
	   {
		   return true;
	   }
	return false;  
	}
	public static void main(String[] args) {
       student st = new student("Shubham", 28, 87.56);
       student st1 = new student("Shubham 1", 25, 97.05);
       st.printdetails();
       st1.printdetails();       
	}
}
