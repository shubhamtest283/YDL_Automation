package method_and_constructor;

public class mobile {
	
       String brand;
       int price;
       
       mobile()
       {
    	   
       }
       void setdatails(String brand, int price)
       {
    	   this.brand = brand;
    	   this.price = price;
       }
       void showmobile() 
       {
    	   System.out.println("brand name is:- " + brand);
    	   System.out.println("price is:- " + price);
       }
	public static void main(String[] args) {
      
		mobile mb = new mobile();
		mobile mb2 = new mobile();
		mobile mb1 = new mobile();
		
		mb.setdatails("Samsung", 25000);
		mb1.setdatails("Motorola", 22000);
		mb2.setdatails("Apple", 125000);
		
		mb.showmobile();
		mb1.showmobile();
		mb2.showmobile();
		
		
	}

}
