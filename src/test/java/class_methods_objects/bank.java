package class_methods_objects;
public class bank {
    int account_number = 532323236;
    double balance_amount = 52632.56;
    
    void deposit(double deposit_amt)
    {
      	balance_amount = deposit_amt+balance_amount;
      	System.out.println("Deposit Amount:- " + deposit_amt);
    }
    void withdraw(double withdraw_amt)
    {
    	balance_amount = balance_amount-withdraw_amt;
    	System.out.println("Withdraw amount:- " + withdraw_amt);
    }
   double getbalance() 
    {	    
    	return balance_amount;	
    }
	public static void main(String[] args) {
     bank bn = new bank();
     bn.withdraw(15000);
     bn.deposit(25000);
     System.out.println("Balance Amount:- " + bn.getbalance());
	}
}
