package class_methods_objects;

public class car {
      
	String brand;
	String model;
	int price;
	
	void startengine() 
	{
		System.out.println("Started engine of "+ brand +" " + model + " and price of this car is " + price);
	}
	void stopengine() 
	{
		System.out.println("stopped engine of "+ brand +" " + model + " and price of this car is " + price);

	}
	public static void main(String[] args) {
		
       car ca = new car();
       ca.brand = "Toyota";
       ca.model = "etios";
       ca.price = 1800000;
       ca.startengine();
       ca.stopengine();
	}

}
