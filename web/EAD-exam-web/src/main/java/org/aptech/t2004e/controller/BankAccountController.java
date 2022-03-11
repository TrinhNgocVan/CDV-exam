package org.aptech.t2004e.controller;

import java.util.EnumSet;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aptech.t2004e.common.constant.RateByTermOfLoanEnum;
import org.aptech.t2004e.common.dto.BankAccountDto;
import org.aptech.t2004e.common.dto.LoanDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.manager.BankAccountManager;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BankAccountController extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	@Autowired
	BankAccountManager bankAccountManager ;
	@GetMapping("/accountRegister/form")
	public ModelAndView list(HttpServletRequest request) throws Exception {
		log.debug("entering 'form' method...");
		ModelAndView modelAndView = new ModelAndView("account-register");
		LoanDto loan = new LoanDto();
		HashMap<String , Object> termOfLoan  = new HashMap<>();
		EnumSet.allOf(RateByTermOfLoanEnum.class).stream().forEach( tl -> termOfLoan.put(tl.name(), tl.value));
		modelAndView.addObject("loanDto", loan);
		modelAndView.addObject("termOfLoan", termOfLoan);
		return modelAndView;
	}
	@PostMapping("/accountRegister/save")
	public String save (BankAccountDto bankAccount, BindingResult bindingResult, HttpServletRequest request)  throws Exception {
		String view = "account-register" ;
		// validate bankAccount
		
		//
		BankAccountDto bankAccountResult =  bankAccountManager.save(bankAccount);
		if(bankAccountResult != null ) {
			addMessage(request, "Đăng ký tài khoản mới thành công . Thông tin tài khoản mới là :  , Không chia sẻ tài khoản này với người khác");
		}else {
			addError(request, "Đăng ký tài khoản không thành công , có lỗi xảy ra trong quá trình thực hiện");
		}
		return view ;
	}
}
