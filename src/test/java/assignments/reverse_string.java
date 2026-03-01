package assignments;

public class reverse_string {

	public static void main(String[] args) {
		//reverse string using charat and length method
      /*String s = "shubham";
      String rev = "";
      
      for(int i = s.length()-1; i>=0; i--) 
      {
            rev = rev+s.charAt(i);
      }
      System.out.println(rev);*/
	
		//by converting string to char array type
	/*	
		String s = "welcome";
		String rev = "";
		
		char a[] = s.toCharArray();
		for(int i = s.length()-1; i >= 0; i--) 
		{
			rev = rev+a[i];
			
		}
		System.out.println(rev);
		*/
		//using StringBuffer class
		StringBuffer s = new StringBuffer("test");
		System.out.println(s.reverse());
		
		//using StringBuilder class
		StringBuilder p = new StringBuilder("java");
		System.out.println(p.reverse());
	}

}
