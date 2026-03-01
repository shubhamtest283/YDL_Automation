package method_and_constructor;

public class electricitybill {
     String customer_name;
     int units;
     int bill_amount;
     
     electricitybill(String customer_name, int units)
     {
    	this.customer_name = customer_name; 
    	this.units = units;
     }
     int calculatebill()
     {
    	 if(units <= 50) 
    	 {
    		 bill_amount = 5*units;
    	 }
    	 else if(units<=100) 
    	 {
    		bill_amount = 7*units; 
    	 }
    	 else 
    	 {
    		bill_amount = 10*units; 
    	 }
    	 return bill_amount;
     }
     void printbill()
 	{
 		System.out.println("Customer Name is:- " + customer_name); 
 		System.out.println("Total units is:- " + units); 
 		System.out.println("Total Bill Amount is:- " + bill_amount); 
 	 }
	public static void main(String[] args) {
		electricitybill eb = new electricitybill("Shubham Patil", 51);
		eb.calculatebill();
		eb.printbill();
	}

}
