package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	// Member Table
	private String memId;
	private String memName;
	// Hobby table
	private String hobbyList[];
	// AddressVo
	private AddressVO addressVo;
	// CardVo
	private List<CardVO> cardList;

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", hobbyList=" + Arrays.toString(hobbyList)
				+ ", addressVo=" + addressVo + ", cardList=" + cardList + "]";
	}

}
