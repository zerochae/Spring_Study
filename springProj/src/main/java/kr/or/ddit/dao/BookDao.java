package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
	 
	 Dao클래스 : mapper XML을 실행
	 
	 Repository 어노테이션이 붙은 클래스는 스프링이 데이터를 관리하는 클래스라고 인지
	 자바빈으로 등록하여 관리함
	 
	 
 */

@Repository
public class BookDao {
	
	//DI(Dependency Injection)
	//new 키워를 통해 직접 생성하지 않고
	//스프링이 미리 만들어 놓은 sqlSessionTemplate 타입 객체를
	//BookDao 객체에 주입함
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public String insert(Map<String,Object> map) {
		//book_SQL.xml 파일의 namespace가 book이고 , id가 insert인 구문을 찾아 실행
		//map을 파라미터로 보냄
		
		this.sqlSessionTemplate.insert("book.insert",map);
		
		return map.get("bookId").toString();
		
		
	}
	
	// 책 상세보기
	public Map<String , Object> select(Map<String,Object> map){
		// selectOne 메소드 : 1행을 가져올 때 사용
		// 결과 행 수가 0 일때 null 반환
		// 결과 행 수가 2 이상일 때 TooManyResultsException 예외 발생 
		// ( namespace.id , 파라미터 )
		return sqlSessionTemplate.selectOne("book.select",map);
	}
	
	public boolean update(Map<String,Object> map){
		
		return this.sqlSessionTemplate.update("book.update",map) > 0;
	}
	
	public boolean delete(Map<String,Object> map) {
		
		//RDBMS(Relational DatabaseManagement System)에서
		//delete 구문은 update 구문처럼 조건에 일치하는
		// 모든 행을 삭제하므로 영향을 받은 행의 수는 0 혹은 1이상이 됨
		return this.sqlSessionTemplate.delete("book.delete",map) > 0;
	}
	
	public List<Map<String,Object>> list(Map<String,Object> map){
		return this.sqlSessionTemplate.selectList("book.list",map);
	}
	
	
 	
}
