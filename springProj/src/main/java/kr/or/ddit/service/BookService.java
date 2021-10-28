package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	// 메소드 시그니처
	String insert(Map<String, Object> map);

	Map<String, Object> select(Map<String, Object> map);

	boolean update(Map<String, Object> map);

	boolean delete(Map<String, Object> map);

	
	public List<Map<String, Object>> list();

}
