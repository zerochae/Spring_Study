package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

public interface ShopSerivce {
	
	public List<Map<String,Object>> list();
	
	public Map<String,Object> detail(Map<String,Object> map);

}
