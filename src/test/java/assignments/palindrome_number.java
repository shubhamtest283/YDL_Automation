package assignments;

public class palindrome_number {

	public static void main(String[] args) {
       int a = 112211;
       int b = 0;
       
       
       while(a !=0 ) 
       {
    	   int digit = a%10;
    	   b = b*10+digit;
    	   a /=10; 
       }
       System.out.println("org= "+ a + " b= " + b);
       if(a==b) {
    	   System.out.println("this is palindrome number");
       }
       else {
    	   System.out.println("not palindrome number");
       }
	}
}
