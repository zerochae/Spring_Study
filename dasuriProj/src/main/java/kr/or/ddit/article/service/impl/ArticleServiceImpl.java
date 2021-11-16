package kr.or.ddit.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.article.mapper.ArticleMapper;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public int insertArticle(ArticleVO articleVO) throws Exception {
		//글정보 테이블로 isnert
		//articleNo <= 0
		int result = this.articleMapper.insertArticle(articleVO);
		
		//글내용 테이블로 insert
		//articleNo <= max(article_no)
		result += this.articleMapper.insertArticleContent(articleVO);
		
		return result;
	}

	@Override
	public List<Map<String, Object>> selectArticle() throws Exception {
		return this.articleMapper.selectArticle();
	}

	@Override
	public int totalArticle() throws Exception {
		return this.articleMapper.totalArticle();
	}
}
