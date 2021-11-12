package kr.or.ddit.cus.vo;

import java.util.Date;

import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
 
@Data
public class CardVO {
	//null 안됨, trim후 길이가 0보다 커야함
	@NotBlank
	private String no; // 카드번호
	
	// 미래 날짜 검사
	@Future
	@DateTimeFormat(pattern = "yyyy-mm")
	private Date validMonth; // 유효년월
	
}
