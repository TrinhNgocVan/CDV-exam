package org.aptech.t2004e.controller;

//import org.aptech.t2004e.common.constant.RateByTermOfLoanEnum;
//import org.aptech.t2004e.common.dto.BankAccountDto;
//import org.aptech.t2004e.common.dto.LoanDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.EmployeeDto;
import org.aptech.t2004e.manager.EmployeeManager;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

		import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class EmployeeController extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	@Autowired
	EmployeeManager employeeManager;
	@GetMapping("/employees")
		public ModelAndView list(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("employees-list");
		modelAndView.addObject("employees", employeeManager.gets());
		return modelAndView;
	}
	@GetMapping("/employee/delete/{id}")
	public String delete(@PathVariable Long id, HttpServletRequest request) throws Exception {
		if(employeeManager.delete(id) == true){
			addMessage(request,"Xóa nhân viên thành công ");
		}else{
			addError(request,"Xoá nhân viên thất bại");
		}
		String view  ="redirect:/employees";
		return view ;
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/employee/form")
	public ModelAndView form(@RequestParam(value = "id",required = false) Long id, HttpServletRequest request) throws Exception {
		log.debug("entering 'form' employee method...");
		EmployeeDto employee = new EmployeeDto();
		if(id != null){
			employee = employeeManager.getById(id);
		}
		ModelAndView modelAndView = new ModelAndView("employee-form");
		modelAndView.addObject("employee" , employee);
		return modelAndView;
	}
	@PostMapping("/employee/save")
	public String save(@ModelAttribute("employee") EmployeeDto e , BindingResult binding , HttpServletRequest request) throws Exception {
		log.info("process='save' method, {}", e);
		if(binding.hasErrors()){
			addError(request , "Lưu thông tin nhân viên thất bại");
		}else{
			EmployeeDto savedEmployeeDto = employeeManager.save(e);
			if(savedEmployeeDto != null){
				addMessage(request , "Cập nhật thông tin nhân viên thành công ");
			}else{
				addError(request , "Cập nhật thông tin nhân viên thất bại ");
			}
		}
		String view = "redirect:/employees";
		return view;
	}
}
