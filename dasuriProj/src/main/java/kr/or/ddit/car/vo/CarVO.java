package kr.or.ddit.car.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVO {

	private String empNo;
	private String addr;
	private String hp;
	private String nm;
	
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", addr=" + addr + ", hp=" + hp + ", nm=" + nm + "]";
	}
}
