package assignments;

public class countnumbers {

	public static void main(String[] args) {
      int num=456427894;
      int count=0;
      
      while(num != 0) 
      {
    	num = num/10;
    	count++;
      }
      System.out.println(count);
	}

}
