package assignments;

public class evenoddcounts {

	public static void main(String[] args) {
		int num=452365856;
		int even=0;
		int odd=0;
		
		while(num !=0) 
		{
		int digit = num%10;
		if(digit%2==0) {
			even++;
		}
		else {
			odd++;
		}
		num = num/10;
		}
		System.out.println("even numbers:- "+even);
		System.out.println("odd numbers:- "+odd);
	}

}
