package realtimeprojects;

public class swapping {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		int c;
		c = a;
		a = b;
		b = c;
		System.out.println("using temporary variable swapping a is "+a+", b is "+b);
	   
	 a = a+b;    //a= 10+20=30 
	 b = a-b;    //b= 30-20=10
	 a = a-b;    //a= 30-10=20
	 System.out.println("using arithmatic operators(+, -) a is " + a + ", b is " + b);
	 
	a= a*b;
	b= a/b;
	a= a/b;
	System.out.println("using arithmatic operators(*, /) a is "+a+", b is "+b);
	
	}

}
