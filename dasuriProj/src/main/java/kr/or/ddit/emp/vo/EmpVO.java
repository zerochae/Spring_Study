package kr.or.ddit.emp.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
	
	private String fireYn; // 퇴직여부
	
	
}
