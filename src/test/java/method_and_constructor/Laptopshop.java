package method_and_constructor;

public class Laptopshop {
	
	String brand;
	String ram;
	int price;
	
	Laptopshop(String brand)
	{
		this(brand, "8 GB", 40000);
	}
	Laptopshop(String brand, String ram)
	{
		this(brand, ram, 40000);
	}
	Laptopshop(String brand, String ram, int price)
	{
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	
	void showlaptop()
	{
	   System.out.println("Laptop Brand Name Is:- " + brand);	
	   System.out.println("Laptop RAM Is:- " + ram);
	   System.out.println("Laptop Price Is:- " + price);
	}

	public static void main(String[] args) {
         
		Laptopshop ls = new Laptopshop("HP");
		Laptopshop ls1 = new Laptopshop("Dell", "4 GB");
		Laptopshop ls2 = new Laptopshop("acer", "16 GB", 75000);
		
		ls.showlaptop();
		ls1.showlaptop();
		ls2.showlaptop();
	}

}
