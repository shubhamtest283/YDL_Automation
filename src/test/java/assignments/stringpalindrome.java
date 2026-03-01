package assignments;

public class stringpalindrome {

	public static void main(String[] args) {
         String s = "naman";
         String a = "";
         
         for(int i = s.length()-1; i>=0; i--) 
         {
        	a = a+s.charAt(i);
         }
         
         if(s.equals(a)) 
         {
        	 System.out.println("S is a palindrome string");
         }
         else 
         {
        	System.out.println("S is not palindrome string"); 
         }
	}

}
