package kr.or.ddit.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.ShopSerivce;

@Controller
public class ShopController {
	
	@Autowired
	ShopSerivce shopSerivce;
 
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@GetMapping("/")
	public String welcome() {
		logger.info("welcome");
		return "welcome";
	}
	
	@GetMapping("/addProduct")
	public String addProduct() {
		logger.info("addProduct");
		return "addProduct";
	}
	
	@GetMapping("/editProduct")
	public ModelAndView editProduct(@RequestParam String edit,ModelAndView mav) {
		logger.info("editProduct" + edit);
		List<Map<String,Object>> list = this.shopSerivce.list();
		mav.addObject("data",list);
		mav.addObject("edit",edit);
		return mav;
	}
	
	@ResponseBody 
	@GetMapping("/products")
	public ModelAndView list(ModelAndView mav) {
		
		List<Map<String,Object>> list = this.shopSerivce.list();
		
		logger.info("list" + list);
		
		mav.addObject("data",list);
		
		return mav;
	}
	
	@GetMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam String id,@RequestParam Map<String,Object> map,ModelAndView mav) {
		
		map.put("P_ID", id);
		
		Map<String,Object> detailMap = this.shopSerivce.detail(map);
		
		logger.info("udpateProduct");
		
		mav.addObject("id",id);
		mav.addObject("data",detailMap);
		
		return mav;
	}
	
	@GetMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam String id,ModelAndView mav) {
		
		logger.info("deleteProduct");
		
		mav.addObject("id",id);
		
		return mav;
	
		
	}
	
	
	
	@GetMapping("/product")
	@ResponseBody
	public ModelAndView Product(@RequestParam String id,@RequestParam Map<String,Object> map,ModelAndView mav) {
		
		logger.info("product");
		
		logger.info("id : " + id);
		
		map.put("P_ID", id);
		
		Map<String,Object> detailMap = this.shopSerivce.detail(map);
		
		logger.info("detailMap : " + detailMap);
		
		mav.addObject("data",detailMap);
		
		return mav;
		
	}
	
}
