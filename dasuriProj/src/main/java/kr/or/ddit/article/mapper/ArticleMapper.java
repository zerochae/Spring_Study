package kr.or.ddit.article.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleMapper {

	int insertArticle(ArticleVO articleVO);
	
	int insertArticleContent(ArticleVO articleVO);
	
	List<Map<String,Object>> selectArticle(); 
	
	int totalArticle();
	
}
