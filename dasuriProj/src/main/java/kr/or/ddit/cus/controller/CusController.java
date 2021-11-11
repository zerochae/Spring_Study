package kr.or.ddit.cus.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.cus.vo.Member;
import kr.or.ddit.emp.controller.EmpController;

@Controller
public class CusController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	

	@GetMapping("cus/registerForm01")
	public String list(Model model) {
		
//		Map<String,String> genderCodeMap = new HashMap<>();
		
//		genderCodeMap.put("01", "Male");
//		genderCodeMap.put("02", "Femail");
//		genderCodeMap.put("03", "Other");
		
		Member member = new Member();
		member.setGender("female");
//		
		model.addAttribute("member", member);
//		model.addAttribute("genderCodeMap",genderCodeMap);
		
		return "cus/registerForm";
	}
	
	@PostMapping("cus/register")
	public String register(@Validated Member member,BindingResult result) {
		
		logger.info("register");
		
		logger.info("result.hasErrors() : " + result.hasErrors());
		
		if(result.hasErrors()) {
			return "cus/registerForm";
		}
		
		return "cus/success";
	}
	
}
