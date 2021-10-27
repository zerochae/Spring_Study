package kr.or.ddit.controller;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.or.ddit.service.BookService;


/*
 	Controller 어노테이션
 	
 	개발자가 스프링 프레임워크에게 이 클래스는 웹 브라우저의 요청(request)을 받아들이는 컨트롤러야 라고 알려주는 것이예요
 	
 	스프링 프레임워크(디자인패턴 + 라이브러리) ㅇ ㅣ클래스가 컨트롤러라고 인지를 해서 자바빈(java bean)으로 등록하여 관리
 	
 	ex) /notice/listo
 	
 */



@Controller
public class BookController {
	
	//서비스를 호출하기 위해 의존성 주입(DI)
	//인터페이스가 사용됨
	@Autowired
	BookService bookService;
	// 책을 등록할 때 요청
	// value 속성 : 웹브라우저에서 요청한 주소 (URI)
	@RequestMapping(value = "/create",method=RequestMethod.GET)
	public ModelAndView create() {
		/*
		 
		  ModelAndView
		  1) Model : Controller 가 반환할 데이터를 담당
		  2) View : 화면을 담당
		 
		 */
		
		
		// 1 .
		
//		return new ModelAndView ("book/create");
		
		//웹 브라우저에서 /create 를  get으료 요청
		// book/create 경로의 뷰를 담당
		

		// 2. 
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("book/create");
//		this.bookService.insert(map);
		return mav;
		
	}
	//title = 제목 & category = 카테고리 & price = 10000
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		
		ModelAndView mav = new ModelAndView();
		
		String bookId = this.bookService.insert(map);
		
		System.out.println("bookId : " + bookId);
		
		if(bookId == null) { //insert가 안됨 -> 책 입력 화면으로 되돌아감
			
			mav.setViewName("redirect/create");
			
		} else { // insert가 되면 -> 상세 페이지를 요청
			
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}
		
		return mav;
	}
	
	// 파라미터 목록  : bookId = 1
	// {"bookId" , "1"}
	
	@RequestMapping(value="/detail" , method = RequestMethod.GET)
	public ModelAndView select(@RequestParam Map<String,Object> map) {
		Map<String,Object> detailMap = this.bookService.select(map);
		
		ModelAndView mav = new ModelAndView();
		
		//request.setAttribute("data",detailMap) 랑 유사
		mav.addObject("data",detailMap);
		
		String bookId = map.get("bookId").toString();
		
		mav.addObject("bookId",bookId);
		
		mav.setViewName("/book/detail");
		
		return mav;
		
	}
	
	
}

