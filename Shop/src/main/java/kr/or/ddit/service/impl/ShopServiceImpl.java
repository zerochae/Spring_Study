package kr.or.ddit.service.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ShopDao;
import kr.or.ddit.service.ShopSerivce;

@Service
public class ShopServiceImpl implements ShopSerivce {

	@Autowired
	ShopDao shopDao;

	@Override
	public List<Map<String, Object>> list() {
		return this.shopDao.list();
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.shopDao.detail(map);
	}

	@Override
	public boolean insert(Map<String, Object> map) {
		return this.shopDao.insert(map);
	}

	@Override
	public boolean delete(Map<String, Object> map) {
		return this.shopDao.delete(map);
	}

	@Override
	public boolean update(Map<String, Object> map) {
		return this.shopDao.update(map);
	}

	@Override
	public boolean update2(Map<String, Object> map) {
		return this.shopDao.update(map);
	}

	@Override
	public List<Map<String, Object>> addCart(Map<String, Object> map, HttpSession session) {

		Map<String, Object> item = this.shopDao.detail(map);
		boolean flag = true;
		String item_id = item.get("P_ID").toString();

		List<Map<String, Object>> cart = (ArrayList<Map<String, Object>>) session.getAttribute("cartList");

		for (int i = 0; i < cart.size(); i++) {

			if (cart.get(i).containsValue(item_id)) {
				cart.get(i).put("quantity", (Object) (Integer.parseInt(cart.get(i).get("quantity").toString()) + 1));
				flag = false;
			}
		}

		if (flag) {
			item.put("quantity", 1);
			cart.add(item);
		}

		session.setAttribute("cartList", cart);
		return cart;
	}

	@Override
	public List<Map<String, Object>> removeCart(Map<String, Object> map, HttpSession session) {

		List<Map<String, Object>> cart = (ArrayList<Map<String, Object>>) session.getAttribute("cartList");
		String item_id = map.get("P_ID").toString();
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).containsValue(item_id)){
				cart.remove(i);
			}
		}
		
		return cart;
	}

	@Override
	public void orderConfirmation(Map<String, Object> map, HttpServletRequest request,HttpServletResponse response) {
		
		try {
			Cookie cartId = new Cookie("Shipping_cartId",URLEncoder.encode(request.getParameter("cartId"),"UTF-8"));
			Cookie name = new Cookie("Shipping_name",URLEncoder.encode(request.getParameter("name"),"UTF-8"));
			Cookie shippingDate = new Cookie("Shipping_shippingDate",URLEncoder.encode(request.getParameter("shippingDate"),"UTF-8"));
			Cookie country = new Cookie("Shipping_country",URLEncoder.encode(request.getParameter("country"),"UTF-8"));
			Cookie zipCode = new Cookie("Shipping_zipCode",URLEncoder.encode(request.getParameter("zipCode"),"UTF-8"));
			Cookie addressName = new Cookie("Shipping_addressName",URLEncoder.encode(request.getParameter("addressName"),"UTF-8"));
			
			cartId.setMaxAge(24 * 60 * 60);
			name.setMaxAge(24 * 60 * 60);
			shippingDate.setMaxAge(24 * 60 * 60);
			country.setMaxAge(24 * 60 * 60);
			zipCode.setMaxAge(24 * 60 * 60);
			addressName.setMaxAge(24 * 60 * 60); 
			
			response.addCookie(cartId);
			response.addCookie(name);
			response.addCookie(shippingDate);
			response.addCookie(country);
			response.addCookie(zipCode);
			response.addCookie(addressName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String,Object> shippingInfo(Cookie[] cookies) {
		
		Map<String,Object> map = new HashMap<>();
		
		String shipping_cartId = ""; 
		String shipping_name = ""; 
		String shipping_shippingDate = "";
		String shipping_country = "";
		String shipping_zipCode = "";
		String shipping_addressName = "";
		
		try {
			
			if(cookies != null){
				
				for(int i = 0; i<cookies.length; i++){
					
					Cookie thisCookie = cookies[i];
					String n = thisCookie.getName();
					
					if(n.equals("Shipping_cartId")){
						shipping_cartId = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					if(n.equals("Shipping_name")){
						shipping_name = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					if(n.equals("Shipping_shippingDate")){
						shipping_shippingDate = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					if(n.equals("Shipping_country")){
						shipping_country = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					if(n.equals("Shipping_zipCode")){
						shipping_zipCode = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					if(n.equals("Shipping_addressName")){
						shipping_addressName = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
					} 
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("shipping_cartId",shipping_cartId);
		map.put("shipping_name",shipping_name);
		map.put("shipping_shippingDate",shipping_shippingDate);
		map.put("shipping_country",shipping_country);
		map.put("shipping_zipCode",shipping_zipCode);
		map.put("shipping_addressName",shipping_addressName);
		
		return map;
	}

	@Override
	public List<Map<String,Object>> orderList(HttpSession session) {
		
		List<Map<String, Object>> cart = (ArrayList<Map<String, Object>>) session.getAttribute("cartList");
		
		if(cart != null) {
			
			for(int i =0; i<cart.size(); i++) {
				
				int price = Integer.parseInt(cart.get(i).get("P_UNITPRICE").toString());
				int qty = Integer.parseInt(cart.get(i).get("quantity").toString());
			
				cart.get(i).put("total",price * qty);
			}
		}
		return cart;
	}

	@Override
	public void removeSessionAndCookie(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		Cookie cookies[] = request.getCookies();
		
		session.invalidate();
		for (int i = 0; i < cookies.length; i++) {
			Cookie thisCookie = cookies[i];
			String n = thisCookie.getName();
			if (n.equals("Shipping_cartId"))
				thisCookie.setMaxAge(0);
			if (n.equals("Shipping_name"))
				thisCookie.setMaxAge(0);
			if (n.equals("Shipping_shippingDate"))
				thisCookie.setMaxAge(0);
			if (n.equals("Shipping_country"))
				thisCookie.setMaxAge(0);
			if (n.equals("Shipping_zipCode"))
				thisCookie.setMaxAge(0);
			if (n.equals("Shipping_addressName"))
				thisCookie.setMaxAge(0);
			
			response.addCookie(thisCookie);
		}
		
	}
}
