package org.aptech.t2004e.controller;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.aptech.t2004e.common.constant.RateByTermOfLoanEnum;
import org.aptech.t2004e.common.constant.TermOfLoanEnum;
import org.aptech.t2004e.common.dto.LoanDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.DemoDto;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoanRegisterController  extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	@GetMapping("/loanRegister/form")
	public ModelAndView list(HttpServletRequest request) throws Exception {
		log.debug("entering 'form' method...");
		ModelAndView modelAndView = new ModelAndView("loan-register");
		LoanDto loan = new LoanDto();
		HashMap<String , Object> termOfLoan  = new HashMap<>();
		EnumSet.allOf(RateByTermOfLoanEnum.class).stream().forEach( tl -> termOfLoan.put(tl.name(), tl.value));
		modelAndView.addObject("loanDto", loan);
		modelAndView.addObject("termOfLoan", termOfLoan);
		return modelAndView;
	}
	@PostMapping("/loanRegister/save")
	public String save(  LoanDto loan,BindingResult bindingResult, HttpServletRequest request) throws Exception {
		log.debug("entering 'save' method...");
		// set rate and termOfLoan by display field 
		EnumSet.allOf(RateByTermOfLoanEnum.class).stream().forEach( r -> {
			if(r.name().equalsIgnoreCase(loan.getDisplayTermOfLoan())) {
				loan.setRate(r.value);
			}
		});
		EnumSet.allOf(TermOfLoanEnum.class).stream().forEach(tl -> {
			if(tl.name().equalsIgnoreCase(loan.getDisplayTermOfLoan())) {
				loan.setTermOfLoan(tl.value);
			}
		});
		 String view = "loan-register";   
		 if (bindingResult.hasErrors()) {
	        	addError(request, bindingResult.getAllErrors().toString());
	            return view;
	        }
		ResponseEntity<?> response = null;
		response = restHelper.send(serviceProperties.getPaths().get("loan-save"), HttpMethod.POST, loan, LoanDto.class);
		if(response == null ) {
			addError(request, "Thong tin dang ky khoan vay moi khong duoc chap nhan") ;
		}else {
			LoanDto loanResult = (LoanDto)  response.getBody();
			addMessage(request, "Thong tin dang ky khoan vay moi da duoc chap nhan , so tien lai phai tra hang thang la : "+loanResult.getTienlai()+ "   vnd" );
		}		
		 
		return view;
	}
	
}
