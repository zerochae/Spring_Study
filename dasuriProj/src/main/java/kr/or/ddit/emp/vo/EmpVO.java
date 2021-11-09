package kr.or.ddit.emp.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO {

	private String empNo;
	private String addr;
	private String hp;
	private String nm;
	
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", addr=" + addr + ", hp=" + hp + ", nm=" + nm + "]";
	}
}
