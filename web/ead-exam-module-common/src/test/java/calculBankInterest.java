

public class calculBankInterest {
	
	public void testcalculBankInterest() {
		long loanAmount ;
		double rate ;
		int n ;  // term of the loan.
		loanAmount = 100000 ;
		rate = 0.01 ;
		n = 6 ;
		double amount  = loanAmount * rate * Math.pow(1+rate, n)/(Math.pow(1+rate, n) -1 ) /12 ;
		System.err.println(amount);
	}
}
