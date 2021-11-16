package kr.or.ddit.article.mapper;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleMapper {

	int insertArticle(ArticleVO articleVO);
	
	int isnertArticleContent(ArticleVO articleVO);
	
}
