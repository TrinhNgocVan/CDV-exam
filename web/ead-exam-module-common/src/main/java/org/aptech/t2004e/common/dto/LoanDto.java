package org.aptech.t2004e.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
	private long id ;
	private String name ;
	private String tel ;
	private String address ;
	private long loanAmount ;
	private  double rate ;
	private int  termOfLoan;
	private double tienlai ;
	private String displayTermOfLoan ;
	
}
