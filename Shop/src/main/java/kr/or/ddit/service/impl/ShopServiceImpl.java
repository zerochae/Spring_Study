package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ShopDao;
import kr.or.ddit.service.ShopSerivce;

@Service
public class ShopServiceImpl implements ShopSerivce{
	
	@Autowired
	ShopDao shopDao;

	@Override
	public List<Map<String, Object>> list() {
		return this.shopDao.list();
	}


	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.shopDao.detail(map);
	}

	@Override
	public boolean insert(Map<String, Object> map) {
		return this.shopDao.insert(map);
	}

	@Override
	public boolean delete(Map<String, Object> map) {
		return this.shopDao.delete(map);
	}


	@Override
	public boolean update(Map<String, Object> map) {
		return this.shopDao.update(map);
	}


	@Override
	public boolean update2(Map<String, Object> map) {
		return this.shopDao.update(map);
	}



}
