package kr.or.ddit.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;
import kr.or.ddit.emp.vo.Member;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/emp/list")
	public String list(Model model) throws Exception {
		
		List<EmpVO> list = this.empService.list();
		
		model.addAttribute("list", list);
		
		return "emp/list";
	}
	@GetMapping("/emp/register")
	public String register(Model model) {
		
		logger.info("register");
		
		model.addAttribute("emp",new EmpVO());
		
		return "emp/register";
	}
	
	@PostMapping("/emp/registerPost")
	public String registerPost(@ModelAttribute("emp") @Validated EmpVO emp,BindingResult result) {
		
		logger.info("result" + result.hasErrors());
		
		if(result.hasErrors()) {
			List<ObjectError> allErros = result.getAllErrors();
			List<ObjectError> globalErros = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			logger.info("allErrors.size : " + allErros.size());
			logger.info("globalErros.size : " + globalErros.size());
			logger.info("fieldError.size : " + fieldErrors.size());
			
			for(int i = 0; i<allErros.size(); i++) {
				ObjectError objectError = allErros.get(i);
				logger.info("objectError : " + objectError);
			}
			for(int i = 0; i<globalErros.size(); i++) {
				ObjectError objectError = globalErros.get(i);
				logger.info("objectError : " + objectError);
			}
			for(int i = 0; i<fieldErrors.size(); i++) {
				ObjectError objectError = fieldErrors.get(i);
				logger.info("objectError : " + objectError);
			}
		}
		
		//직원 등록 처리
		
		// 직원 목록으로 이동
		return "redirect:/emp/list";
	}
	
	/*
	 스프링 폼 태그 라이브러리
	 - 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리
	 - 스프링 폼을 이용하면 HTML폼과 자바 객체를 쉽게 바인딩할 수 있음
	 
	 1) form:form (폼)
	 2) form:input (텍스트 필드)
	 3) form:password (패스워드 필드)
	 4) form:textarea (텍스트 영역)
	 5) form:checkboxes (다중 체크박스)
	 6) form:radiobuttons (단일 체크박스)
	 7) form:radiobutton (다중 라디오 버튼)
	 8) form:select (셀렉트 박스)
	 9) form:hidden (숨겨진 필드)
	 10) form:hidden (숨겨진 필드)
	 11) form:label (라벨)
	 12) form:button (버튼)
	 13) form:errors (입력값을 검증 후 오류를 표시)
	 */
	
	@GetMapping("/emp/registerForm02")
	public String registerForm02(Model model,HttpServletRequest request) {
		logger.info("registerForm02");
		
		HttpSession session = request.getSession();
		
		
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null) {
			userId = "a001";
		}
		
		Member member = new Member();
		  
		member.setUserId(userId);
		member.setUserName("김은대");
		member.setEmail("test@test.com");
		member.setPassword("java");
		member.setIntroduction("하이\n헬로우");
		member.setDeveloper("Y");
		member.setForeigner(false);
		
		Map<String,String> hobbyMap = new HashMap<>();
		
		hobbyMap.put("Sports","Sports");
		hobbyMap.put("Music","Music");
		hobbyMap.put("Chess","Chess");
		
		List<String> hobbySelected = new ArrayList<>();
		
		hobbySelected.add("Sports");
		hobbySelected.add("Chess");
		
		member.setHobbyList(hobbySelected);
		
		//성별 라디오 버튼
		
		Map<String,String> genderCodeMap = new HashMap<String,String>();
		
		genderCodeMap.put("Male","Male");
		
		
		
		genderCodeMap.put("Female","Female");
		genderCodeMap.put("Other","Other");
		
		// 국적 셀렉트 박스
		
		Map<String,String> nationalityCodeMap = new HashMap<String,String>();
		
		nationalityCodeMap.put("01","Korea");
		nationalityCodeMap.put("02","China");
		nationalityCodeMap.put("03","Japan");
		
		Map<String,String> carCodeMap = new HashMap<String,String>();
		
		carCodeMap.put("01" , "르노삼성");
		carCodeMap.put("02" , "현다이");
		carCodeMap.put("03" , "더블드래곤");
		
		
		model.addAttribute("member", member);
		model.addAttribute("hobbyMap",hobbyMap);
		model.addAttribute("genderCodeMap",genderCodeMap);
		model.addAttribute("nationalityCodeMap",nationalityCodeMap);
		model.addAttribute("carCodeMap",carCodeMap);
		
		return "emp/registerForm";
	}
	
	@PostMapping("/emp/register")
	public String register(Member member, Model model) {
		logger.info("register");
		logger.info("member" + member.toString());
		
		List<String> hobbyList = member.getHobbyList();
//		if(hobbyList != null) {
//			for(int i =0; i<hobbyList.size(); i++) {
//				logger.info(hobbyList.get(i));
//			}
//		}
		
		List<String> carList = member.getCarList();
		if(carList != null) {
			logger.info("" + carList);
		} else {
			logger.info("carList is empty");
		}
		
		model.addAttribute("member",member);
		model.addAttribute(hobbyList);
		model.addAttribute(carList);
		
		return "emp/result";
	}
	
}
