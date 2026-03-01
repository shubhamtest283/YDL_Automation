package realtimeprojects;

public class largest_number {

	public static void main(String[] args) {
      int a=30, b=20;
      String res=(a<b)? "A is smallest" : "B is smallest";
      System.out.println(res);
      
      int c=10, d=30;
      
      if(c<d) {
    	  System.out.println("c is smallest");
      }
      else {
    	  System.out.println("d is smallest");
      }
      int e=60, f=90, g= 100;
      
      if((e<f) && (e<g)) {
    	  System.out.println("e is smallest");
      }
      else if((f<e) && (f<g)) {
    	  System.out.println("f is smallest");
      }
      else {
    	  System.out.println("g is smallest");
      }
	}
}
