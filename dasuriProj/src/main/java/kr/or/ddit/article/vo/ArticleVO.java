package kr.or.ddit.article.vo;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ArticleVO {
	
	private int articleNo; 
	private WriterVO writerVO;
	@NotBlank
	private String title;
	private Date regdate;
	private Date moddate;
	private ArticleContentVO articleContentVO;
	private int readCnt;
	private MultipartFile multipartFile[];
	
	public ArticleVO() {
		
	}
	
	public ArticleVO(int articleNo, WriterVO writerVO, String title, Date regdate, Date moddate, int readCnt) {
		this.articleNo = articleNo;
		this.writerVO = writerVO;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
	}
}
