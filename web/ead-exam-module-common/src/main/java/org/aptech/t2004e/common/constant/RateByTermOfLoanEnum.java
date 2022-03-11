package org.aptech.t2004e.common.constant;

public enum RateByTermOfLoanEnum {
	SAU_THANG(0.1),
	MOT_NAM(0.13),
	KHONG_KY_HAN(0.12);
	
	public double  value ;
	private RateByTermOfLoanEnum(double value) {
		this.value = value;
	}
}
