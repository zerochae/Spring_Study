package kr.or.ddit.emp.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
 
@Data 
public class Member {
	//NotBlank : 문자열이 null이 아님, trim(공백제가)한 길이가 0보다 커야함
	//Size : 글자 수 , 컬렉션의 요소 개수를 검사
	@NotBlank
	private String userId;
	@NotBlank
	@Size(max=3) 
	private String userName;
	private String email;
	private String password;
	private String introduction;
	private List<String> hobbyList;
	private String developer;
	private boolean foreigner;
	private String gender;
	private String nationality;
	private List<String> carList;
	private Date dateOfBirth;
}
