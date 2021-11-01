package kr.or.ddit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressVO {

	private String postCode;
	private String location;
	
	
	@Override
	public String toString() {
		return "AddressVO [postCode=" + postCode + ", location=" + location + "]";
	}
}
