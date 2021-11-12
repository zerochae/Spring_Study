package kr.or.ddit.article.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleVO {
	
	private int articleNo;
	private WriterVO writerVo;
	private String title;
	private Date regdate;
	private Date moddate;
	private int readCnt;
	
	public ArticleVO(int articleNo, WriterVO writerVo, String title, Date regdate, Date moddate, int readCnt) {
		this.articleNo = articleNo;
		this.writerVo = writerVo;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
	}
}
