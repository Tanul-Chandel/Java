
/*A tester that creates a CalculateInterestCommand, 
 * populates it and forwards it to a ComamandRouter for routing.
 *  When the CalculateInterestCommand returns, 
 *  the returned CalculateInterestCommand would have the interest amount populated in it 
 *  and tester would print it by calling getInterestAmount.*/

public class CalculateInterestCommandTester {

	public static void main(String[] args){
		
		try{
		
		CalculateInterestCommand CIC=new CalculateInterestCommand();
		  
		System.out.println( "Account Number: "+CIC.accountNumber);
		System.out.println("Initial Balance: "+CIC.getBalance());
		System.out.println("Initial Interest Rate: "+CIC.getInterestRate());
		
		CIC.setInterestRate(4.0);
		CIC.deposit((double)((10 - 1+ 1) * Math.random() + 1)*4000.0);
		
		System.out.println("Current Balance: "+CIC.getBalance());
		System.out.println("Current Interest Rate: "+CIC.getInterestRate());
		
		CommandRouter CmdRouter=new CommandRouter();
		
		CIC=(CalculateInterestCommand)CmdRouter.route(CIC);
		
		System.out.println("Interest Amount after server connection is :  "+CIC.getInterestAmount());
	
		}
	
		catch(NegativeAmountException nE){
			nE.toString();
		}
	    catch(Exception e)
		{
			e.printStackTrace();
		}
   }
}
	


