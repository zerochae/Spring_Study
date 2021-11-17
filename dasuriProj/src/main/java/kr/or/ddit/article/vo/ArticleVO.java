package kr.or.ddit.article.vo;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ArticleVO {
	
	private int articleNo; 
	private int RNUM;
	private WriterVO writerVO;
	@NotBlank
	private String title;
	private String regdate;
	private String moddate;
	private ArticleContentVO articleContentVO;
	private int readCnt;
	private MultipartFile multipartFile[];
	
	public ArticleVO() {
		
	}
	 
	public ArticleVO(int articleNo, WriterVO writerVO, String title, String regdate, String moddate, int readCnt,int RNUM) {
		this.articleNo = articleNo;
		this.writerVO = writerVO;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
		this.RNUM = RNUM;
	}
}
