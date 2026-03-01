package assignments;

public class remove_junk_data_from_string {

	public static void main(String[] args) {
        String s = "he5566#@#@#$ll745%$o";
        String a = "";
        
        for(int i = 0; i<s.length(); i++) 
        {
        	char ch = s.charAt(i);
        	
        	if
        	((ch >= 'A' && ch <= 'Z') ||
        	(ch >= 'a' && ch <= 'z')  ||
        	(ch >= 0 && ch <= 9))
        	{
        		a = a+ch;
        	}
        	
        }
        System.out.println(a);
	}

}
