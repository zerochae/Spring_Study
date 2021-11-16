package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleService {
	
	public int insertArticle(ArticleVO articleVO) throws Exception;
	
	public List<Map<String,Object>> selectArticle() throws Exception;
	
	public int totalArticle() throws Exception;
	
}
