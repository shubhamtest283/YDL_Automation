package method_and_constructor;

public class person {
	
	String name;
	int age;
	
	person()
	{
		name = "Shubham";
		age = 29;
		
	}
	
	void printdetails() 
	{
		System.out.println("person name is:- " + name);
		System.out.println("person age is:- " + age);
	}

	public static void main(String[] args) {
      
		person pd = new person();
		
		pd.printdetails();
		
		
	}

}
