package kr.or.ddit.service.impl;

import org.springframework.stereotype.Service;

import kr.or.ddit.service.BoardService;
import kr.or.ddit.vo.MemberVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public int insertMemberHobby(MemberVO memberVo) {
		
		// 1) 회원테이블로 insert
		// int result = BoardDao.insertMemberHobby(memberVo);
		
		// 2) 취미테이블로 insert
		// if(result > 0 ){
		// BoardDao.insertHobby(memberVo);
		// }
		
		
		
		return 0;
	}

}
