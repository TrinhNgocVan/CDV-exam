package org.aptech.t2004e.manager;



//import org.aptech.t2004e.common.dto.BankAccountDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.EmployeeDto;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class EmployeeManager {
	@Autowired
	private RestHelper restHelper;

	@Autowired
	private ServiceProperties serviceProperties;

	public List<EmployeeDto> gets(){
		log.info("process=get-employee, criteria={}");
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-employees-get"), HttpMethod.GET, new ParameterizedTypeReference<List<EmployeeDto>>() {});
		return (List<EmployeeDto>)response.getBody();
	}
	public EmployeeDto getById(long id) {
		log.info("process=get-employee, id={}", id);
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-employees-get-by-id"), HttpMethod.GET, EmployeeDto.class, id);
		return (EmployeeDto) response.getBody();
	}
	public Boolean delete(long id ){
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-employees-delete") , HttpMethod.DELETE ,Boolean.class,id);
		return (Boolean) response.getBody();
	}
	public EmployeeDto save(EmployeeDto e ){
		ResponseEntity<?> response = null ;
		if(e.getId() == null){
			 response = restHelper.send(serviceProperties.getPaths().get("api-employees-create") , HttpMethod.POST , e,EmployeeDto.class);
		}else {
			response = restHelper.send(serviceProperties.getPaths().get("api-employees-update") , HttpMethod.PUT ,e , EmployeeDto.class,e.getId());
		}
		return (EmployeeDto) response.getBody();
	}

}
