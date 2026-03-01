package assignments;

import java.util.Arrays;

public class missing_number_from_array {

	public static void main(String[] args) {
    int a[] = {5,2,4,3,1,8,9,6};
    Arrays.sort(a);
    int missing_number = 1;
    System.out.println(Arrays.toString(a));
    
    for(int i = 0; i<a.length; i++) 
    {
    	if (a[i] != i+1) 
    	{
    		missing_number = i+1;
    		break;
    	}
    }
    System.out.println("missing number is: " + missing_number);
	}
}
