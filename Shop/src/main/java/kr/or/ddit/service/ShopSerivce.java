package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

public interface ShopSerivce {
	
	public List<Map<String,Object>> list();
	
	public Map<String,Object> detail(Map<String,Object> map);
	
	public boolean insert(Map<String,Object> map);
	
	public boolean delete(Map<String,Object> map);
	
	public boolean update(Map<String,Object> map);
	
	public boolean update2(Map<String,Object> map);

}
