package kr.or.ddit.article.vo;

import java.util.List;

import lombok.Data;

@Data
public class ArticlePage {
	
	private int total; // 전체 행의 수 : 140
	private int currentPage; // 현재 페이지 번호
	private List<ArticleVO> content; // 게시글 목록
	private int totalPages; //전체 페이지 수 : 7
	private int startPage; // 시작 페이지 번호 [*1] [2] [3] [4] [5] 다음
	private int endPage; // 종료 페이지 번호 [1] [2] [3] [4] [5*] 다음
	 
	public ArticlePage(int total, int currentPage, List<ArticleVO> content, int size) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0) {
			totalPages = 0;
			startPage  = 0;
			endPage = 0;
		} else { // 결과 행이 있을 때
			// 72행이 있고 5페이지 씩 묶을 때, 한 화면에 10개씩 보일 때
			// 7 <= 72 / 10
			totalPages = total / size;
			// 나머지 행이 있으면 전체 페이지수를 1증가
			if(total % size > 0) {
				totalPages++;
			}
			// 시작 페이지번호 공식
			int modVal = currentPage % 5;
			
			startPage = currentPage / 5 * 5 + 1;
			
			if(modVal == 0) startPage -= 5;
			
			// [1] [2] [3] [4] [5]
			// [6] [7] [8] [9] [10] (endPage)
			
			endPage = startPage + 4;
			if(endPage > totalPages) endPage = totalPages;
			
		}
		
	}
	
	

}
