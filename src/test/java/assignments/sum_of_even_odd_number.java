package assignments;

public class sum_of_even_odd_number {

	public static void main(String[] args) {
      int num = 234615976;
      int even = 0;
      int odd = 0;
      
      while(num !=0) 
      {
    	  int digit = num%10;
    	  if(digit%2==0) 
    	  {
    		even = even+digit;  
    	  }
    	  else 
    	  {
    		 odd = odd+digit; 
    	  }
    	  num = num/10;
      }
	  System.out.println("sum of even number:- "+ even);
	  System.out.println("sum of odd number:- "+ odd);
	}

}
