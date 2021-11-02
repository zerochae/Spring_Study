package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

//	@RequestMapping("/uploadForm")
	@GetMapping("/uploadForm")
	public String uploadForm() {
		logger.info("uploadForm");
		return "uploadForm";
	}

	// 파일업로드 처리
	// RequestMapping(value="/uploadFormAction",method=RequestMethod.POST)
	@PostMapping("/uploadFormAction")
	public String uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\workspace\\6.JspSpring\\springProj\\src\\main\\webapp\\resources\\upload";

		List<String> list = new ArrayList<String>();

		for (MultipartFile multipartFile : uploadFile) {

			logger.info("===================");
			logger.info("업로드 파일명 : " + multipartFile.getOriginalFilename());
			logger.info("업로드 파일 크기 : " + multipartFile.getSize());
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
				// transferTo() 메서드의 파라미터 : java.io.File의 객체
				list.add(multipartFile.getOriginalFilename());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		model.addAttribute("list", list);
		return "uploadFormPost";
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		logger.info("upload ajax");
		// /uploadAjax URI 주소와 uploadAjax.jsp의 위치 및 파일명이
		// 동일하여 return 생략 가능
	}

	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		logger.info("update ajax post..........");

		String uploadFolder = "C:\\workspace\\6.JspSpring\\springProj\\src\\main\\webapp\\resources\\upload";

		for (MultipartFile multipartFile : uploadFile) {

			logger.info("---------------------");
			logger.info("파일명  : " + multipartFile.getOriginalFilename());
			logger.info("파일크기  : " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE에서의 파일명의 경로를 처리
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			logger.info("IE에서 처리한 파일명");
			logger.info(uploadFileName);
			
			// 1) 목적지? 2) 파일명?

			File saveFile = new File(uploadFolder, uploadFileName);

			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
			}
		}
	}
}
