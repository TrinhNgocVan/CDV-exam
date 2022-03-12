package org.aptech.t2004e.common.dto;

import java.time.LocalDate;

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
public class AppUserDto extends BaseDto {
	  private Long id;
	  private String username;
	  private String password;
	  private Integer version;
	  private Integer userLevel;
	  private String createdBy;
	  private LocalDate createdDate;
	  private String modifiedBy;
	  private LocalDate modifiedDate;
}
