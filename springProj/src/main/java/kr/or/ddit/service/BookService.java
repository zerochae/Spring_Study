package kr.or.ddit.service;

import java.util.Map;

public interface BookService {
	// 메소드 시그니처
	String insert(Map<String, Object> map);

	Map<String, Object> select(Map<String, Object> map);

}