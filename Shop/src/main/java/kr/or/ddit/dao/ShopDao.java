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
	
}
