package kr.or.ddit.cus.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data 
public class Member {
	@NotBlank
	private String userId;
	@NotBlank
	@Size(max=3) 
	private String userName;
	private String email;
	@NotBlank
	private String password;
	private String introduction;
	private List<String> hobbyList;
	private String developer;
	private boolean foreigner;
	private String gender;
	private String nationality;
	private List<String> carList;
	@Past @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Valid
	private List<CardVO> cardList;
	
	private AddressVO address;
}
