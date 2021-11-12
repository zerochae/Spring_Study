package kr.or.ddit.emp.mapper;

import java.util.List;

import kr.or.ddit.emp.vo.EmpVO;

public interface EmpMapper {
	
	List<EmpVO> list();
	
	int insert(EmpVO emp);
	
	String createEmpNo();
	
	EmpVO detail(String empNo); 
	
	int update(String empNo);
	
}
