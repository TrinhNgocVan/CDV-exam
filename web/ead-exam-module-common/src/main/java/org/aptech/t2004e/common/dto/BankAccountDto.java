package org.aptech.t2004e.common.dto;

import java.math.BigDecimal;

import org.aptech.t2004e.common.BaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BankAccountDto extends BaseDto {
	private long id ;
	private String accountCode ;
	private String accountName ;
	private String peopleId;
	private BigDecimal accountBallance ;
	private String telephone ;
	private  String  address ;
	private String email ;
	private AppUserDto appUser ;
}
