package org.aptech.t2004e.common.constant;

public enum TermOfLoanEnum {
	SAU_THANG(6),
	MOT_NAM(12),
	KHONG_KY_HAN(36);
	
	public int  value ;
	private TermOfLoanEnum(int value) {
		this.value = value;
	}
}
