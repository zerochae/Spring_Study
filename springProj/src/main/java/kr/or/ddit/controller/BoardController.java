package kr.or.ddit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	/*
	 * 
	 * RequestMapping 어노테이션 정리
	 * 
	 * - value 속성 : 필수 - 속성이 하나일 때 속성명 생략 가능
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	
	//PUT을 쓰면 RequestBody에 JSON데이터가 담긴
	//RequestBody 어노테이션을 통해 JSON 데이터를 VO객체에 자동으로 할당
	@RequestMapping(value="/{boardNo}", method=RequestMethod.PUT)
	public ResponseEntity<String> test1(@PathVariable int boardNo, @RequestBody BoardVO boardVo) {
		logger.info("boardVo : " + boardVo.toString());
		
		// SUCCESS 라는 문자열을 반환
		return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
	}
	
	
	// value 속성에 요청 경로를 설정
//	@RequestMapping(value = "/register")
	@RequestMapping("/register")
	public void registerForm() {
		logger.info("registerForm");
	}

	@RequestMapping("/modify")
	public void modifyForm() {
		logger.info("modifyForm");
	}

	@RequestMapping("/list")
	public void listForm() {
		logger.info("list");
	}
	/*
	 * 
	 * 경로 패턴 매핑 - 경로 변수에 해당하는 값을 파라미터 변수에 설정할 수 있음 -
	 * 
	 */

	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") int boardNo) {
		logger.info("read boardNo" + boardNo);

		// 경로가 변하므로 뷰 이름 지정
		return "board/read";
	}

	/*
	 * Params 매핑 - 요청 파라미터를 매핑 조건으로 지정하는 경우에는 params 속성을 사용 - 버튼이나 링크에 따라 호출할 메서드를
	 * 바꿔야 할 때 사용
	 */

	// <a href="/board/get?register"> Register</a>
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "register")
	public String getForm() {
		logger.info("getForm");

		return "board/register";
	}

	public String getForm2() {
		logger.info("getForm");

		return "board/register";
	}

	public String getForm3() {
		logger.info("getForm");

		return "board/register";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "register")
	public String register() {
		logger.info("register");

		return "board/register";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "modify")
	public String modifty() {
		logger.info("modify");
		return "board/modify";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "remove")
	public String remove() {
		logger.info("remove");
		return "board/remove";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET,params="modify")
	public String modifyGet() {

		logger.info("modifyGet");
		return "board/list";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET,params="remove")
	public String removeGet() {
		
		logger.info("removeGet");
		return "board/list";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET,params="list")
	public String listGet() {
		
		logger.info("listGet");
		return "board/list";
	}
	
	@RequestMapping("/registerCheckbox02")
	public String registerCheckbox02() {
		logger.info("registerCHeckbox02");
		
		return "sub/registerCheckbox02";
	}
	//폼 체크박스 요소값을 문자열 배열 타입 매개변수로 처리
	@ResponseBody
	@RequestMapping(value="/registerCheckbox",method=RequestMethod.POST)
	public String[] registerCheckbox(MemberVO memberVo,String hobbyList[]) {
		logger.info("registerCheckbox");
		
		// null -> 체크한것이 없을때
		if(hobbyList != null) {
			logger.info("hobbyList.length : " + hobbyList.length);
			
			for(int i =0; i<hobbyList.length; i++) {
				logger.info("hobbyList [" + i + "]  => " + hobbyList[i]);
			}
		}
		
		
		
		AddressVO addressVo = memberVo.getAddressVo();
		
		if(addressVo != null) {
			logger.info("addressVo.getPostCode() : " + addressVo.getPostCode());
			logger.info("addressVo.getLocation() : " + addressVo.getLocation());
		}
		
		//List<CardVO>
		
		List<CardVO> cardList = memberVo.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() : " + cardList.size() );
			
			for (CardVO card : cardList) {
				logger.info("card.getNo() : " + card.getNo());
				logger.info("card.getValidMonth() : " + card.getValidMonth());
			}
		}
		
		logger.info("memberVo : " + memberVo);
		
		return hobbyList;
	}

	@RequestMapping("/registerCheckbox05")
	public String registerCheckbox05() {
		
		logger.info("registerCheckbox05");
		//forwarding
		return "sub/registerCheckbox05";
	}
	
	// 폼 체크박스 요소 값을 boolean 타입으로 작성하면, boolean 타입 매개변수로 처리
	@RequestMapping(value="registerCheckbox05Post",method=RequestMethod.POST)
	public String registerCheckbox05Post(boolean foreigner) {
		
		logger.info("registerCheckbox05Post");
		logger.info("foreigner = " + foreigner);
		
		return "success";
	}

}
