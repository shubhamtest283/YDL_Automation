package method_and_constructor;

import java.util.Scanner;

public class bankaccount {
	
	int accnumber;
	double balance;
	
	bankaccount(int accnumber, double balance)
	{
		this.accnumber = accnumber;
		this.balance = balance;
	}
	
	double deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter deposit amount:- ");
		double dep = sc.nextDouble();
		double finaldepamt = balance + dep;
		balance = finaldepamt;
		return finaldepamt;
	}
	double withdrawal() 
	{
		Scanner sc1 = new Scanner(System.in);
		System.out.println("enter withdraw amount:- ");
		double withdraw = sc1.nextDouble();
		if(withdraw > balance) 
		{
			System.out.println("not enough balance");
			return balance;
		}
		double finalamt = balance - withdraw; 
		balance = finalamt;
		return finalamt;	
	}
	
	void printbalance() 
	{
		System.out.println("Your balance amount is:- " + balance);
	}

	public static void main(String[] args)
	{
		bankaccount bc = new bankaccount(1234556789, 2564.66);
		bc.deposit();
		bc.withdrawal();
		bc.printbalance();
	}

}
