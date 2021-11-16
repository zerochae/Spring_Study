package kr.or.ddit.article.vo;

import lombok.Data;

@Data
public class ArticleContentVO {

	private int articleNo; 
	private String content;
	
	public ArticleContentVO() {
		
	}
	 
	public ArticleContentVO(int articleNo,String content) {
		this.articleNo = articleNo;
		this.content = content;
	}
}
