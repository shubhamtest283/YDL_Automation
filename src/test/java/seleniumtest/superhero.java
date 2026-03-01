package seleniumtest;

public class superhero {
     String name;
     String power;
     int strength;
     
     public superhero(String n, String p, int s) {
    	 name = n;
    	 power = p;
    	 strength = s;
     }
     
     public void showdetails() {
    	 System.out.println("name: " + name);
    	 System.out.println("power: " + power);
    	 System.out.println("strength: " + strength);
     }
     
}
