package array_assignment;

public class search_element_in_array {

	public static void main(String[] args) {
     int a[] = {100, 200, 600, 800, 900, 50, 300};
     boolean status = false;
     for(int i = 0; i<a.length; i++) 
     {
    	 if(a[i] == 20) 
    	 {
    		System.out.println(a[i]);
    		status = true;
    		break;
    	 }
     }
     if(status == false) {
     System.out.println("element not found");
     }
    	 
     }
	}


