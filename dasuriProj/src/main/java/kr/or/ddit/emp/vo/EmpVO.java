package kr.or.ddit.emp.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO implements Serializable {
	
	@NotBlank
	private String empNo;
	@NotBlank
	private String addr;
	@NotBlank
	private String hp;
	@NotBlank
	private String nm;
	@NotBlank
	private String postNo;
	
	private String addr2;
	
	private String password;
	
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", addr=" + addr + ", hp=" + hp + ", nm=" + nm + ", postNo=" + postNo
				+ ", addr2=" + addr2 + ", password=" + password + "]";
	}
	
	
	
}
