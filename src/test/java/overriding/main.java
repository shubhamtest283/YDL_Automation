package overriding;
public class main {

	public static void main(String[] args) {
     Bank b1 = new SBI();
     Bank b2 = new HDFC();
     
     System.out.println("SBI Intrest Rate is:- " + b1.getinterest());
     System.out.println("HDFC Intrest Rate is:- " + b2.getinterest());
	}
}
