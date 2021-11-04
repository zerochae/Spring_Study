package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView updateProduct(@RequestParam Map<String, Object> map, ModelAndView mav) {

		Map<String, Object> detailMap = this.shopSerivce.detail(map);

		logger.info("updateProduct");

		mav.addObject("data", detailMap);

		return mav;
	}

	@PostMapping("/update")
	public ModelAndView update(@RequestParam Map<String, Object> map, ModelAndView mav,MultipartFile P_FILENAME) {

		boolean isUpdate = false;

		if (P_FILENAME != null) {
			map.put("P_FILENAME", P_FILENAME.getOriginalFilename());
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
	public Model Product(@RequestParam Map<String, Object> map, Model model) {
		

		logger.info("product");

		logger.info("map : " + map);

		Map<String, Object> detailMap = this.shopSerivce.detail(map);

		logger.info("detailMap : " + detailMap);

//		mav.addObject("data", detailMap);
		
		model.addAttribute("data",detailMap);

		return model;

	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam String id, @RequestParam Map<String, Object> map, ModelAndView mav) {

		logger.info("delete");
		logger.info("id : " + id );
		logger.info("map : " + map);
		
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
	public ModelAndView insert(@RequestParam Map<String, Object> map, ModelAndView mav,MultipartFile P_FILENAME) {
		
		logger.info("insert");
		
		map.put("P_FILENAME", P_FILENAME.getOriginalFilename());
		
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
	
	@PostMapping("/addCart")
	public ModelAndView addCart(@RequestParam Map<String,Object> map, HttpServletRequest request,ModelAndView mav,MultipartFile P_FILENAME) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cartList")==null) {
			session.setAttribute("cartList", new ArrayList<Map<String,Object>>());
		}
		logger.info("addCart");
		logger.info("session : "+ session.getAttribute("cartList").toString());
		logger.info("map : " + map);
		
		Map<String,Object> detail = this.shopSerivce.detail(map);
		logger.info("detail : " + detail);
		
		List<Map<String,Object>> cart = this.shopSerivce.addCart(detail, session);
		
		logger.info("cart : " +cart.toString()); 
		
		mav.addObject("cart",cart);
		
		mav.setViewName("redirect:/product?P_ID="+map.get("P_ID"));
		
		return mav;
	}
	
	@GetMapping("/cart")
	public ModelAndView cart(@RequestParam Map<String,Object> map, ModelAndView mav,HttpServletRequest request) {
		
		logger.info("cart");
		
		HttpSession session = request.getSession();
		
		String session_id = session.getId();
		
		if(session.getAttribute("cartList")==null) {
			session.setAttribute("cartList", new ArrayList<Map<String,Object>>());
		}
		
		logger.info("session : "+ session.getAttribute("cartList").toString());
		
		ArrayList<Map<String,Object>> cart = (ArrayList<Map<String,Object>>)session.getAttribute("cartList");
		
		
		mav.addObject("session_id",session_id);
		mav.addObject("cart",cart);
		
		return mav;
		
	}
	
	@GetMapping("/deleteCart")
	public ModelAndView deleteCart(ModelAndView mav, HttpServletRequest request) {
		
		HttpSession session = request.getSession();	
		session.invalidate();
		mav.setViewName("redirect:/cart");
		
		return mav;
	}
	
	@GetMapping("/removeCart")
	public ModelAndView removeCart(@RequestParam Map<String,Object> map,HttpServletRequest request, ModelAndView mav) {
		
		logger.info("removeCart");
		logger.info("map : " + map);
		
		HttpSession session = request.getSession();
		
		List<Map<String,Object>> cart = this.shopSerivce.removeCart(map, session); 
		
		session.setAttribute("cartList", cart);
		
		mav.setViewName("redirect:/cart");
		
		return mav;
	}
	
	@GetMapping("shippingInfo")
	public ModelAndView shippingInfo(HttpServletRequest request,ModelAndView mav) {
		
		logger.info("shippingInfo");
		
		HttpSession session = request.getSession();
		
		String cartId = session.getId();
		
		mav.addObject("cartId",cartId);
		
		return mav;
	}
	
	@PostMapping("/orderConfirmation")
	public ModelAndView orderConfirmation(@RequestParam Map<String,Object> map,HttpServletRequest request,HttpServletResponse response, ModelAndView mav) {
		
		logger.info("shippingInfo");
		
		HttpSession session = request.getSession();
		
		String session_id = session.getId();
		
		this.shopSerivce.orderConfirmation(map, request, response);
		
		Cookie[] cookies = request.getCookies();
		
		Map<String,Object> shippingInfo = this.shopSerivce.shippingInfo(cookies);
		
		logger.info(shippingInfo.toString());
				
		List<Map<String,Object>> orderList = this.shopSerivce.orderList(session);
		
		mav.addObject("session_id",session_id);
		mav.addObject("orderList",orderList);
		mav.addObject("shippingInfo",shippingInfo);
		
		return mav;
	}
	
	@GetMapping("/thankCustomer")
	public ModelAndView thank(@RequestParam Map<String,Object> map,HttpServletRequest request,HttpServletResponse response, ModelAndView mav) {
		
		Cookie[] cookies = request.getCookies();
		
		Map<String,Object> shippingInfo = this.shopSerivce.shippingInfo(cookies);
		
		logger.info(shippingInfo.toString());
		
		mav.addObject("shippingInfo",shippingInfo);
		
		this.shopSerivce.removeSessionAndCookie(request, response);
		
		return mav;
	}
}
