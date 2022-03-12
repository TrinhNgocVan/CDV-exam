package org.aptech.t2004e.common.helper;

import java.text.DecimalFormat;

public  class LoanHelper {
	public static double  calculBankInterest(long loanAmount , double rate  , int n ) {
//		n  : term of the loan.
		double tienLaiHangThang =  loanAmount * rate * Math.pow(1+rate, n)/(Math.pow(1+rate, n) -1 ) /12 ;
		
		// làm tròn đến 2 chữ số thập phân
		return Math.round(tienLaiHangThang * 100.0) / 100.0;
	}
}
