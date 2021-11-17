package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleService {
	
	public int insertArticle(ArticleVO articleVO) throws Exception;
	
	public List<ArticleVO> selectArticle(Map<String,Object> map) throws Exception;
	
	public int totalArticle() throws Exception;
	
}
