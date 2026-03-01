package class_methods_objects;

public class day1 {
	
	void addition(int a, int b)
	{
		System.out.println(a+b);
	}
	void subsctraction(int c, int d) 
	{
		System.out.println(c-d);
	}
	void multiply(int e, int f) 
	{
		System.out.println(e*f);
	}
	void divide(int g, int h) 
	{
		System.out.println(g/h);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      day1 dy = new day1();
      dy.addition(10, 20);
      dy.subsctraction(30, 20);
      dy.multiply(40, 50);
      dy.divide(20, 2);
      
	}

}
