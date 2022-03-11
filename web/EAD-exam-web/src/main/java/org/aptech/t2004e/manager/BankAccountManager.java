package org.aptech.t2004e.manager;



import org.aptech.t2004e.common.dto.BankAccountDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BankAccountManager {
	@Autowired
	private RestHelper restHelper;

	@Autowired
	private ServiceProperties serviceProperties;
	
	public BankAccountDto save(BankAccountDto bankAccountDto) {
		log.info("process=save-Device, deviceDto{}", bankAccountDto);
		ResponseEntity<?> response = null;
		response = restHelper.send(serviceProperties.getPaths().get("bankAccount-save"), HttpMethod.POST, bankAccountDto, BankAccountDto.class);
		return (BankAccountDto)response.getBody();
	}
}
