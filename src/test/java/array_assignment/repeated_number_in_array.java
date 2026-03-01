package array_assignment;

public class repeated_number_in_array {

	public static void main(String[] args) {
    int a[] = {10,20,30,10,20,50,10,60,50,20};
    int num = 60;
    int count = 0;
    
    for(int value:a) 
    {
    	if(value == num) 
    	{
    		count++;
    	}
    }
    System.out.println(count);
	}

}
