package assignments;

public class swapping_without_using_variable {

	public static void main(String[] args) {
     int a = 20;
     int b = 30;
     
     a = a*b;  //we can also use +,- operators instead of *,/
     b = a/b;
     a = a/b;
     
     System.out.println("a= "+a + " b= "+b);
	}

}
