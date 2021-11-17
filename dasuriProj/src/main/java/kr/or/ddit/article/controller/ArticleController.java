package kr.or.ddit.article.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleContentVO;
import kr.or.ddit.article.vo.ArticlePage;
import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.WriterVO;
import kr.or.ddit.emp.vo.EmpVO;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@GetMapping("/newArticleForm")
	public String newArticleForm(Model model) {
		model.addAttribute("article", new ArticleVO());
		// forwarding
		return "article/newArticleForm";
	} 

	@PostMapping("/newArticlePost")
	public String newArticlePost(@ModelAttribute("article") ArticleVO article, HttpServletRequest request)
			throws Exception {

		HttpSession session = request.getSession();

		// EMPVO라는 이름의 세션의 정보를 가져와 직원데이터를 empVO 객체에 할당
		EmpVO empVO = (EmpVO) session.getAttribute("EMPVO");

		WriterVO writerVO = new WriterVO(empVO.getEmpNo(), empVO.getNm());

		// article 객체의 작성자 중첩객체 필드로 setting을 함
		article.setWriterVO(writerVO);

		logger.info("newArticlePost" + article.toString());

		int result = this.articleService.insertArticle(article);

		logger.info("result : " + result);

		return "article/newArticleSuccess";
	}

	@GetMapping("/listArticle")
	public String listArticle(Model model, @RequestParam(value = "currentPage", defaultValue = "1") String currentPage)
			throws Exception {

		Map<String, Object> pageMap = new HashMap<>();

//		// 시작 페이지번호 공식
//		int modVal = Integer.parseInt(currentPage) % 5;
//
//		int startPage = Integer.parseInt(currentPage) / 5 * 5 + 1;
// 
//		if (modVal == 0)
//			startPage -= 5;
//
//		// [1] [2] [3] [4] [5]
//		// [6] [7] [8] [9] [10] (endPage)
// 
//		int endPage = startPage + 4;
		int total = this.articleService.totalArticle();
//		
//		int totalPages = total / 10;
//		
//		if (endPage > totalPages)
//			endPage = totalPages;

		pageMap.put("currentPage", Integer.parseInt(currentPage));

		List<ArticleVO> articleList = this.articleService.selectArticle(pageMap);
  
//		int total = this.articleService.totalArticle();

//		List<ArticleVO> articleList = new ArrayList<>();

		if (articleList != null) {
			logger.info("mapList : " + articleList.get(0).toString());
		}

//		for (Map<String, Object> map : mapList) {
//				
//				WriterVO writerVO = new WriterVO(String.valueOf(map.get("WRITER_ID")),String.valueOf(map.get("WRITER_NAME")));
//				ArticleContentVO articleContentVO = new ArticleContentVO(Integer.parseInt(String.valueOf(map.get("ARTICLE_NO"))),String.valueOf(map.get("CONTENT")));
//				
//				ArticleVO articleVo = 
//						new ArticleVO(
//								Integer.parseInt((String.valueOf(map.get("ARTICLE_NO")))),
//								writerVO,
//								(String)map.get("TITLE"),
//								(Date)map.get("REGDATE"),
//								(Date)map.get("MODDATE"),
//								Integer.parseInt(String.valueOf(map.get("READ_CNT")))
//								);
//				
////				logger.info("writerVo : " + writerVO);
////				logger.info("articleContentVO : " + articleContentVO);
////				logger.info("articleVo : " + articleVo);
//				
//				articleList.add(articleVo);
//			}

		model.addAttribute("articlePage", new ArticlePage(total, Integer.parseInt(currentPage), articleList, 10));

		return "article/listArticle";
	}

}
