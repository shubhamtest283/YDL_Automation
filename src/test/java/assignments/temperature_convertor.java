package assignments;

public class temperature_convertor {

	public static void main(String[] args) {
      Double celcius = 35.0;
      Double f;
      
      
      f = celcius * 9/5 + 32;
      System.out.println("F = "+f);
      
      celcius = (f - 32) * 5/9;
      System.out.println("Celcius = "+celcius);
      
	}
}
