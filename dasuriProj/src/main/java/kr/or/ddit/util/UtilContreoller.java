package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilContreoller {

	private static final Logger logger = LoggerFactory.getLogger(UtilContreoller.class);
		 
	
	@GetMapping("/chart/charts")
	public ModelAndView charts(ModelAndView mav) {
		
		
//		mav.setViewName("chart/charts");
		
		return mav;
		
	}
	
	@GetMapping("/chart/chart02")
	public String chart02() {
		return "chart/chart02";
	}
}
