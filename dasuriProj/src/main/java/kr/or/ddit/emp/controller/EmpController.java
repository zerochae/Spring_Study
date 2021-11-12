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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;
import kr.or.ddit.emp.vo.Member;

@Controller
public class EmpController {
   private static final Logger logger = 
         LoggerFactory.getLogger(EmpController.class);
   
   @Autowired
   EmpService empService;
   
   @RequestMapping("/emp/list")
   public String list(Model model) throws Exception {
      List<EmpVO> list = this.empService.list();
      
      model.addAttribute("list", list);
      
      return "emp/list";
   }
   //직원 등록 폼
   @RequestMapping("/emp/register")
   public String register(Model model) throws Exception {
      logger.info("register");
      
      EmpVO empVo = new EmpVO();
      
      //직원번호 자동생성
      String empNo = this.empService.createEmpNo();
      
      empVo.setEmpNo(empNo);
      
      model.addAttribute("emp", empVo);
      
      return "emp/register";
   }
   
   //요청 파라미터 목록을 VO에 할당 시 ModelAttribute 어노테이션이 필요함 
   @RequestMapping(value="/emp/registerPost",method=RequestMethod.POST)
   public String registerPost(@ModelAttribute("emp") @Validated EmpVO emp,
            BindingResult result) throws Exception {
      logger.info("result : " + result.hasErrors());
      //validate 후 문제가 발생하면 실행
      if(result.hasErrors()) {
         List<ObjectError> allErrors = result.getAllErrors();
         List<ObjectError> globalErrors = result.getGlobalErrors();
         List<FieldError> fieldErrors =  result.getFieldErrors();
         
         logger.info("allErrors.size() : " + allErrors.size());
         logger.info("globalErrors.size() : " + globalErrors.size());
         logger.info("fieldErrors.size() : " + fieldErrors.size());
         
         for(int i=0;i<allErrors.size();i++) {
            ObjectError objectError = allErrors.get(i);
            logger.info("objectError : " + objectError);
         }
         for(int i=0;i<globalErrors.size();i++) {
            ObjectError objectError = globalErrors.get(i);
            logger.info("objectError : " + objectError);
         }
         for(int i=0;i<fieldErrors.size();i++) {
            FieldError fieldError = fieldErrors.get(i);
            logger.info("fieldError : " 
            + fieldError.getDefaultMessage());
         }
         
         return "emp/register";
      }
      
      //직원 등록 처리
      int insertResult = this.empService.insert(emp);
      
      //직원 목록으로 이동
      return "redirect:/emp/list";
   }
   
   //직원 상세보기 화면
   @RequestMapping("/emp/detail")
   public String detail(@RequestParam("empNo") String empNo,
         Model model) throws Exception {
      logger.info("detail");
      
      EmpVO empVo = this.empService.detail(empNo);
      logger.info("empVo : " + empVo);
      
      model.addAttribute("emp", empVo);
      
      //forwarding
      return "emp/detail";
   }
   
   @PostMapping("/emp/deletePost")
   public String deletePost(@RequestParam("empNo") String empNo) throws Exception {
	   
	   int result = this.empService.update(empNo);
	   
	   return "redirect:/emp/detail?empNo="+empNo;
   }
   
   //요청 파라미터 목록을 VO에 할당 시 ModelAttribute 어노테이션이 필요함 
   @RequestMapping(value="/emp/detailPost",method=RequestMethod.POST)
   public String detailPost(@ModelAttribute("emp") @Validated EmpVO emp,
            BindingResult result, Model model) throws Exception {
      logger.info("result : " + result.hasErrors());
      //validate 후 문제가 발생하면 실행
      if(result.hasErrors()) {
         List<ObjectError> allErrors = result.getAllErrors();
         List<ObjectError> globalErrors = result.getGlobalErrors();
         List<FieldError> fieldErrors =  result.getFieldErrors();
           
         logger.info("allErrors.size() : " + allErrors.size());
         logger.info("globalErrors.size() : " + globalErrors.size());
         logger.info("fieldErrors.size() : " + fieldErrors.size());
         
         for(int i=0;i<allErrors.size();i++) { 
            ObjectError objectError = allErrors.get(i);
            logger.info("objectError : " + objectError);
         }
         for(int i=0;i<globalErrors.size();i++) {
            ObjectError objectError = globalErrors.get(i);
            logger.info("objectError : " + objectError);
         }
         for(int i=0;i<fieldErrors.size();i++) {
            FieldError fieldError = fieldErrors.get(i);
            logger.info("fieldError : " 
            + fieldError.getDefaultMessage());
         }
         
         model.addAttribute("emp", emp);
         
         return "emp/detail";
      }
      
      //직원 등록 및 직원 존재 시 정보 업데이트 처리
      int insertResult = this.empService.insert(emp);
      
      //직원 목록으로 이동
      return "redirect:/emp/list";
   }
   
   /*
    스프링 폼 태그 라이브러리
    - 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리
    - 스프링 폼을 이용하면 HTML 폼과 자바 객체를 쉽게 바인딩할 수 있음
    
    1) form:form (폼)
    2) form:input (텍스트 필드)
    3) form:password (패스워드 필드)
    4) form:textarea (텍스트 영역)
    5) form:checkboxes (다중 체크박스)
    6) form:checkbox (단일 체크박스)
    7) form:radiobuttons (다중 라디오 버튼)
    8) form:radiobutton (단일 라디오 버튼)
    9) form:select (셀렉트 박스)
    10) form:hidden (숨겨진 필드)
    11) form:label (라벨)
    12) form:button (버튼)
    13) form:errors (입력값을 검증 후 오류를 표시)
    */
   //테스트 폼
   @RequestMapping("/emp/registerForm02")
   public String registerForm02(Model model, 
         HttpServletRequest request) {
      logger.info("registerForm02");
      
      //로그인 후 세션정보 다루기
      HttpSession session = request.getSession();
      //직원id를 받아올 수 있음
      String userId = (String)session.getAttribute("userId");
      
      if(userId==null) {
         userId = "a001";
      }
      
      Member member = new Member();
      //폼 객체의 프로퍼티 값을 지정
      member.setUserId(userId);
      member.setUserName("김은대");
      member.setEmail("test@test.com");
      member.setPassword("java");
      member.setIntroduction("하이\n빅스비");
      //개발자여부 Y
      member.setDeveloper("Y");
      //외국인여부 true
      member.setForeigner(false);
      
      //checkboxes 데이터 바인딩
      Map<String,String> hobbyMap = new HashMap<String,String>();
      hobbyMap.put("01", "Sports");
      hobbyMap.put("02", "Music");
      hobbyMap.put("03", "Chess");
      
      //취미 기본 체킹
      List<String> hobbySelected =  
            new ArrayList<String>();
      hobbySelected.add("01");
      hobbySelected.add("03");
      member.setHobbyList(hobbySelected);
      
      //성별 라디어버튼들
      Map<String,String> genderCodeMap = 
            new HashMap<String, String>();
      genderCodeMap.put("01", "Male");
      genderCodeMap.put("02", "Female");      
      genderCodeMap.put("03", "Other");      
            
      //국적 셀렉트 박스
      Map<String,String> nationalityCodeMap = 
            new HashMap<String,String>();
      nationalityCodeMap.put("01", "Korea");
      nationalityCodeMap.put("02", "Germany");
      nationalityCodeMap.put("03", "Australia");
      
      //소유차량 멀티셀렉트박스
      Map<String,String> carCodeMap = 
            new HashMap<String, String>();
      carCodeMap.put("01", "르노삼성");
      carCodeMap.put("02", "현대");
      carCodeMap.put("03", "쌍용");
      
      //속성명에 member는 폼 객체의 모델로 사용됨
      model.addAttribute("member", member);
      model.addAttribute("hobbyMap", hobbyMap);
      model.addAttribute("genderCodeMap", genderCodeMap);
      model.addAttribute("nationalityCodeMap", nationalityCodeMap);
      model.addAttribute("carCodeMap",carCodeMap);
      
      
      return "emp/registerForm";
   }
   
   @RequestMapping(value="/emp/register", method=RequestMethod.POST)
   public String register(@Validated Member member, 
         Model model, BindingResult result) {
      logger.info("register");
      
      logger.info("result.hasErrors() : " + result.hasErrors());
      
      if(result.hasErrors()) {
         return "emp/registerForm";
      }
      
      member.setUserName("개똥이");
      
      //취미 체크박스를 확인
      List<String> hobbyList = member.getHobbyList();
      if(hobbyList!=null) {
         logger.info("hobbyList!=null : " + hobbyList.size());
         
         for(int i=0;i<hobbyList.size();i++) {
            logger.info("hobbyList(" + i + ") : " + hobbyList.get(i));
         }
      }
      
      //소유차량 확인
      List<String> carList = member.getCarList();
      if(carList!=null) {
         logger.info("carList!=null : " + carList.size());
         
         for(int i=0;i<carList.size();i++) {
            logger.info("carList(" + i + ") = " + carList.get(i));
         }
      }else {
         logger.info("carList==null");
      }
      
      logger.info("member : " + member.toString());
      
      model.addAttribute("member", member);
      model.addAttribute("hobbyList", hobbyList);
      model.addAttribute("carList", carList);
      
      return "emp/result";
   }
}






