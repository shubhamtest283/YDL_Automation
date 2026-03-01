package assignments;

public class stringcomprasion {

	public static void main(String[] args) {
		//== comparing the objects whereas .equals() compare the value of objects
		//case 1
		String s1 = "welcome"; //here not created a object so return a same output using both method
		String s2 = "welcome";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		//case 2
		String a1 = new String("welcome"); //here created a object so return different output
		String a2 = new String("welcome");
		
		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));

		//case 3
		
		String b1 = "abc";
		String b2 = new String("abc");
		
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
		
		//case 4
		
		String c1 = "abc";
		String c2 = new String("abc");
		String c3 = c2;
		
		System.out.println(c2==c3);//because c2 assigned to c3 so object is same its return true
		System.out.println(c1==c2);
		System.out.println(c1.equals(c3));
	}
	

}
