package kr.or.ddit.cus.vo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class AddressVO {
	
	@NotBlank
	private String postCode;
	@NotBlank
	private String location;
	private String location2;
	

	
}
