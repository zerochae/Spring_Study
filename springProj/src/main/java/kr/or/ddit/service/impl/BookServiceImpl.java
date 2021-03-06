package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;

/*
 
  	스프링한테 이 클래스는 서비스클래스라고 알려줌
  	스프링 MVC 구조에서 Controller와 DAO를 연결하는 역할
  	
  	스프링 프레임워크는 직접 클래스를 생성하는것을 지양하고
  	인터페이스를 통해 접근하는 것을 권장ㄹ하고 있기 때문
  	그래서 서비스 레이어는 인터페이스와 클래스를 함께 사용함
 
 */
@Service
public class BookServiceImpl implements BookService {
	
	// 데이터베이스 접근을 위해 BookDao 인스턴스를 주입받음
	
	@Autowired
	BookDao bookDao;
	
	
	@Override
	public String insert(Map<String,Object> map) {
		return this.bookDao.insert(map);
	}
	
	// 책 상세보기
	@Override
	public Map<String , Object> select(Map<String,Object> map){
		System.out.println("test1");
		return this.bookDao.select(map);
	}
	
	public boolean update(Map<String,Object> map){
		
		return this.bookDao.update(map);
	}
	
	public boolean delete (Map<String,Object> map) {
		return this.bookDao.delete(map);
	}
	  
	public List<Map<String,Object>> list(Map<String,Object> map){
		return this.bookDao.list(map);
	}
}
