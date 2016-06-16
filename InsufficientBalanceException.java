

public class InsufficientBalanceException extends Throwable{

	
	private static final long serialVersionUID = 1L;
	private double amount;
	private double balance;
	

	public InsufficientBalanceException(double anyAmount, double anyBalance){
		amount = anyAmount;
		balance = anyBalance;
		
	}
	
	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

    public String toString() {
		return "Insufficient Balance, balance is " + balance +" but the withdrawal amount is: " + amount;
	}	
}

