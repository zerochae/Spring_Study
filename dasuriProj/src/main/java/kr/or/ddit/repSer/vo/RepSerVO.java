package kr.or.ddit.repSer.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepSerVO {
	
	private String serNo;
	private String empNo;
	private String cusNo;
	private int repPay;
	private int repTm;
	
	@Override
	public String toString() {
		return "RepSerVO [serNo=" + serNo + ", empNo=" + empNo + ", cusNo=" + cusNo + ", repPay=" + repPay + ", repTm="
				+ repTm + "]";
	}
	
	

}
