package method_and_constructor;

public class student_marks {
	String name;
	double marks;
	
	student_marks(String name, double marks)
	{
		this.name = name;
		this.marks = marks;
	}
	
	boolean ispassed()
	{
		
		if(marks>=35) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	void printresult()
	{

		System.out.println("Student Name Is:- " + name);
		System.out.println("Student Marks Is:- " + marks);
		//System.out.println("Student Result Is:- " + ispassed());
		if(ispassed() == true)
		{
			System.out.println(name + " is passed");
		}
		else 
		{
			System.out.println(name + " is failed");
		}
	}

	public static void main(String[] args) {
       
		student_marks sm = new student_marks("Shubham", 33.99);
		student_marks sm1 = new student_marks("test", 34.00);
		student_marks sm2 = new student_marks("testing", 35.99);
		
		sm.printresult();
		sm1.printresult();
		sm2.printresult();
	}

}
