package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.client.HttpServerErrorException;

public interface ShopSerivce {
	
	public List<Map<String,Object>> list();
	
	public Map<String,Object> detail(Map<String,Object> map);
	
	public List<Map<String, Object>> addCart(Map<String,Object> map, HttpSession session);
	
	public List<Map<String, Object>> removeCart(Map<String,Object> map, HttpSession session);
	
	public void orderConfirmation(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response);
	
	public void removeSessionAndCookie(HttpServletRequest request, HttpServletResponse response);
	
	public Map<String,Object> shippingInfo(Cookie[] cookies);
	
	public List<Map<String,Object>> orderList(HttpSession session);
	
	public boolean insert(Map<String,Object> map);
	
	public boolean delete(Map<String,Object> map);
	
	public boolean update(Map<String,Object> map);
	
	public boolean update2(Map<String,Object> map); 
	
	

}
