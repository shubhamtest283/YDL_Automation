package array_assignment;

public class prime_number {

	public static void main(String[] args) {
		        int num = 29; // You can change this number to test others
		        boolean isPrime = true;

		        if (num <= 1) {
		            isPrime = false;
		        } else {
		            for (int i = 2; i * i <= num; i++) { // using i*i instead of Math.sqrt(num)
		                if (num % i == 0) {
		                    isPrime = false;
		                    break;
		                }
		            }
		        }

		        if (isPrime)
		            System.out.println(num + " is a prime number.");
		        else
		            System.out.println(num + " is not a prime number.");
		    }

	}

