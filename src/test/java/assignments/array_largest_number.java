package assignments;

public class array_largest_number {

	public static void main(String[] args) {
      int a[] = {60,20,50,100,30};
      int largest = a[0];
      for(int i = 0; i<a.length; i++) {
        if(a[i] < largest) {
        	largest = a[i];
        }
      }
      System.out.println(largest);
	}

}
