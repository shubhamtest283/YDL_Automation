package assignments;

public class remove_spaces_from_string {

	public static void main(String[] args) 
	{
		String s = "s hu  b ha m";
		/*String a = s.replace(" ", "");
		System.out.println(a);*/
		String a = "";
		
		for(int i = 0; i<s.length(); i++) 
		{
			if(s.charAt(i) != ' ') 
			{
				a = a+s.charAt(i);
			}
		}
		System.out.println("s = "+s);
		System.out.println("a = "+a);

	}

}
