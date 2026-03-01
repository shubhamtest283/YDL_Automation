package assignments;

public class sum_of_number_digit {

	public static void main(String[] args) {
     int num=1234;
     int sum=1;
     
     while(num != 0) 
     {
    	int digit = num%10;
    	sum = sum*digit;
    	num = num/10;
     }
     System.out.println(sum);
	}
}
