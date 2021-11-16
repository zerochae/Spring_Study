package kr.or.ddit.article.controller;

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

import kr.or.ddit.article.service.ArticleService;
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
		model.addAttribute("article",new ArticleVO());
		//forwarding
		return "article/newArticleForm";
	}
	 
	@PostMapping("/newArticlePost")
	public String newArticlePost(@ModelAttribute("article") ArticleVO article, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		//EMPVO라는 이름의 세션의 정보를 가져와 직원데이터를 empVO 객체에 할당
		EmpVO empVO = (EmpVO)session.getAttribute("EMPVO");
		
		WriterVO writerVO = new WriterVO(empVO.getEmpNo(),empVO.getNm());
		
		//article 객체의 작성자 중첩객체 필드로 setting을 함
		article.setWriterVo(writerVO);
		
		logger.info("newArticlePost" + article.toString());
		
		int result = this.articleService.insertArticle(article);
		
		logger.info("result : " + result);
		
		return "article/newArticleSuccess";
	}

	
	
}
