package kr.or.ddit.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AttachFileVO {

		private String fileName;
		private String uploadPath;
		private String uuid;
		private boolean image;
	
}
