package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerByParameter(String userId,String password) {
		logger.info("registerByParameter" + userId  +" / "+ password);
		return "success";
	}
}
