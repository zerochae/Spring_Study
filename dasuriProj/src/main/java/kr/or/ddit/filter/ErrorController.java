package kr.or.ddit.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	
	@GetMapping("/error/error404")
	public String error404() {
		//forwarding
		return "error/error404";
	}

	@GetMapping("/error/error500")
	public String error500() {
		//forwarding
		return "error/error500";
	}
	
	
}
