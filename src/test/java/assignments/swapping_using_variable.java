package assignments;

public class swapping_using_variable {

	public static void main(String[] args) {
      int a=20;
      int b=30;
      int c;
      
      c= a;
      a= b;
      b= c;
      System.out.println("a = "+a +" b = "+b);
      
      a=a+b;
      b=a-b;
      a=a-b;
      
      System.out.println("a = "+a + " b = "+b);
	}

}
