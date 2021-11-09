package kr.or.ddit.cus.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CusVO {
	
	private String carNo;
	private String cusNo;
	private int yy;
	private int driDis;
	private String manuf;
	
	
	@Override
	public String toString() {
		return "CusVO [carNo=" + carNo + ", cusNo=" + cusNo + ", yy=" + yy + ", driDis=" + driDis + ", manuf=" + manuf
				+ "]";
	}
	
	
	

}
