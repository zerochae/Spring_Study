package kr.or.ddit.article.vo;

import lombok.Data;

@Data
public class WriterVO {

	private String writerId;
	private String writerName;
	
	public WriterVO(String writerId, String writerName) {
		this.writerId = writerId;
		this.writerName = writerName;
	}
}
