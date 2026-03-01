package array_assignment;

import java.util.Arrays;

public class sorting_an_array {

	public static void main(String[] args) {
    int a[] = {100, 300, 20, 50, 600, 200, 150, 400, 10};
    
    System.out.println("Before sorting......");
    System.out.println(Arrays.toString(a));
    
    Arrays.sort(a);
    
    System.out.println("After sorting......");
    System.out.println(Arrays.toString(a));
	}

}
