package array_assignment;

import java.util.Arrays;

public class sorting_strings_in_array {

	public static void main(String[] args) {
    String a[] = {"shubham", "abhishek", "rushi", "chirag", "sushmit", "bhushan", "gaurav"};
    
    
    System.out.println("Before sorting.....");
    System.out.println(Arrays.toString(a));
    
    Arrays.sort(a);
    
    System.out.println("After sorting.....");
    System.out.println(Arrays.toString(a));
	}

}
