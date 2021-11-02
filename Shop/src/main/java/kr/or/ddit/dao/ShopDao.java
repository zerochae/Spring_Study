package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String,Object>> list(){
		return this.sqlSessionTemplate.selectList("shop.list");
	}
	
	public Map<String,Object> detail(Map<String,Object> map){
		return this.sqlSessionTemplate.selectOne("shop.detail",map);
	}
	
	public boolean insert(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.insert("shop.insert",map) > 0;
	}
	
	public boolean delete(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.delete("shop.delete",map) > 0;
	}
	
	public boolean update(Map<String,Object> map) {
		return this.sqlSessionTemplate.update("shop.update",map) > 0;
	}
	
	public boolean update2(Map<String,Object> map) {
		return this.sqlSessionTemplate.update("shop.update",map) > 0;
	}
	
}
