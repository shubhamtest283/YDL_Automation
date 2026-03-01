package assignments;

import java.util.Arrays;

public class sort_array {

	public static void main(String[] args) {
      int a[] = {50,30,60,10,40,22};
      Arrays.sort(a);
      for(int i=0; i<a.length; i++) 
      {
    	  for(int j=i+1; j<a.length; j++) 
    	  {
    		  //System.out.println("i "+ a[i]);
    		  //System.out.println("j "+ a[j]);
    		  
    		  if(a[i]>a[j]) 
    		  {
    			 int temp = a[i];
    			 a[i] = a[j];
    			 a[j] = temp;
    			 //System.out.println(temp);
    		  }
    		  
    	  }
      }
      System.out.println("Sorted Array");
      for(int n : a) {
    	  System.out.println(n + " ");
      }
	}

}
