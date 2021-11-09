package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

public interface ShopMapper {
	// mapper XML의 id
	public Map<String,Object> detail(Map<String,Object> map);
	
	public boolean update(Map<String,Object> map);
	
	public boolean update2(Map<String,Object> map);
	
	public boolean insert(Map<String,Object> map);
	
	public boolean delete(Map<String,Object> map); 
	
	public List<Map<String,Object>> list();
	
	
	
	

}
