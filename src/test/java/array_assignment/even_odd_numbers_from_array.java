package array_assignment;

public class even_odd_numbers_from_array {

	public static void main(String[] args) {
    int a[] = {1, 11, 3, 5, 8, 6, 9, 4, 10, 7};
    int even = 0;
    int odd = 0;
    
    for(int i = 0; i<a.length; i++) {
    	if(a[i]%2 == 0) 
    	{
    		even = even+1;
    	}
    	else {
    		odd = odd+1;
    	}
    }
    System.out.println("even= "+ even);
    System.out.println("odd= "+ odd);
	}

}
