package kr.or.ddit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CardVO {
	
	//카드번호
	private String no;
	//유효연월
	private String validMonth;
	
	@Override
	public String toString() {
		return "CardVO [no=" + no + ", validMonth=" + validMonth + "]";
	}
}
