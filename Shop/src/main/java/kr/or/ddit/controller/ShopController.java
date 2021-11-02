package kr.or.ddit.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView editProduct(@RequestParam String edit, ModelAndView mav) {
		logger.info("editProduct" + edit);
		List<Map<String, Object>> list = this.shopSerivce.list();
		mav.addObject("data", list);
		mav.addObject("edit", edit);
		return mav;
	}

	@ResponseBody
	@GetMapping("/products")
	public ModelAndView list(ModelAndView mav) {

		List<Map<String, Object>> list = this.shopSerivce.list();

		logger.info("list" + list);

		mav.addObject("data", list);

		return mav;
	}

	@GetMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam String id, @RequestParam Map<String, Object> map,
			ModelAndView mav) {

		map.put("P_ID", id);

		Map<String, Object> detailMap = this.shopSerivce.detail(map);

		logger.info("updateProduct");

		mav.addObject("id", id);
		mav.addObject("data", detailMap);

		return mav;
	}

	@PostMapping("/update")
	public ModelAndView update(@RequestParam Map<String, Object> map, ModelAndView mav) {

		boolean isUpdate = false;

		if (map.get("P_FILENAME") != null) {
			logger.info("update");
			logger.info(map.toString());
			isUpdate = this.shopSerivce.update(map);

		} else {
			logger.info("update2");
			logger.info(map.toString());
			isUpdate = this.shopSerivce.update2(map);
		}

		if (isUpdate) {
			logger.info("success");
			mav.setViewName("redirect:/products");
		} else {
			logger.info("fail");
			mav.setViewName("redirect:/updateProduct" + map.get("P_ID"));
		}

		return mav;
	}

	@GetMapping("/product")
	@ResponseBody
	public ModelAndView Product(@RequestParam String id, @RequestParam Map<String, Object> map, ModelAndView mav) {

		logger.info("product");

		logger.info("id : " + id);

		map.put("P_ID", id);

		Map<String, Object> detailMap = this.shopSerivce.detail(map);

		logger.info("detailMap : " + detailMap);

		mav.addObject("data", detailMap);

		return mav;

	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam String id, @RequestParam Map<String, Object> map, ModelAndView mav) {

		logger.info("delete");

		map.put("P_ID", id);

		boolean isDel = this.shopSerivce.delete(map);

		if (isDel) {
			logger.info("success");
			mav.setViewName("redirect:/products");
		} else {
			logger.info("fail");
			mav.setViewName("redirect:/editProduct?edit=delete");
		}

		return mav;

	}

	@PostMapping("/insert")
	public ModelAndView insert(@RequestParam Map<String, Object> map, ModelAndView mav) {
		
		logger.info("insert");
		
		boolean isInsert = this.shopSerivce.insert(map);
		
		if(isInsert) {
			logger.info("success");
			logger.info(map.toString());
			mav.setViewName("redirect:/products");
		} else {
			logger.info("fail");
			logger.info(map.toString());
			mav.setViewName("redirect:/addProduct");
		}
		
		return mav;
	}

}
