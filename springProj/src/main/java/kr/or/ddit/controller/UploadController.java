package kr.or.ddit.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.vo.AttachFileVO;
import net.coobird.thumbnailator.Thumbnailator;

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
	
	@ResponseBody
	@PostMapping("/uploadAjaxAction")
	public List<AttachFileVO> uploadAjaxPost(MultipartFile[] uploadFile) {
//	public ResponseEntity<List<AttachFileVO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		logger.info("update ajax post..........");
		
		List<AttachFileVO> list = new ArrayList<AttachFileVO>();
		
		String uploadFolder = "C:\\workspace\\6.JspSpring\\springProj\\src\\main\\webapp\\resources\\upload";

		//날짜 계층형 폴더 생성
		
		File uploadPath = new File(uploadFolder,getFolder());
		
		logger.info("upload path : " + uploadPath);
		//생성된 폴더가 존재ㅑ하지 않으면
		if(!uploadPath.exists()) {
			//해당 폴더들을 생성해준다. -> 연도>월>일
			uploadPath.mkdirs();
		}
		
		for (MultipartFile multipartFile : uploadFile) {
			AttachFileVO attachFileVO = new AttachFileVO();
			logger.info("---------------------");
			logger.info("파일명  : " + multipartFile.getOriginalFilename());
			logger.info("파일크기  : " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE에서의 파일명의 경로를 처리
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			logger.info("IE에서 처리한 파일명");
			logger.info(uploadFileName);
			
			//1) vo에 파일명 setting
			attachFileVO.setFileName(uploadFileName);
			
			// 1) 목적지? 2) 파일명?
			
			//java.util.UUID 를 통해 파일 중복 방지
			//randomUUID() : 임의의 값을 생성
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() +"_"+ uploadFileName;

			File saveFile = new File(uploadPath, uploadFileName);

			try {
				// 파일 복사 실행
				multipartFile.transferTo(saveFile);
				logger.info("uploadPath.getAbsolutePath() : " + uploadPath.getAbsolutePath());
				// 2) vo객체의 저장 경로 setting
				attachFileVO.setUploadPath(uploadPath.getAbsolutePath());
				// 3) vo객체의 uuid setting
				attachFileVO.setUuid(uuid.toString());
				// 썸네일 만들기 시작 --
				// /uploadAjax를 통해 이미지를 업로드 하면
				// 1) 원본 이미지 파일 저장
				// 2) 섬네일(s_원본이미지 파일) 파일 생성
				// but) 일반 파일은 원본 이미지 파일 저장
				// 이미지인지 체킹
				if(checkImageType(saveFile)) { // 이미지인 경우
					// 4) Vo객체의 이미지 여부 setting
					attachFileVO.setImage(true);
					// 썸네일 => s_이미지파일명
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					
					Thumbnailator.createThumbnail(
							multipartFile .getInputStream(),thumbnail,100,100
							);
					thumbnail.close();
					
				}
				
				// 썸네일 만들기 끝 --
				
				list.add(attachFileVO);
				
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
			}
		}
		//JSON 데이터를 반환
//		return new ResponseEntity<>(list,HttpStatus.OK);
		return list;
	}
	
	// 날짜 계층형 폴더
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		//2021 폴더 -> 11 폴더 -> 02 폴더
		return sdf.format(date).replace("-",File.separator);
	}
	
	// 이미지의 경우에만 섬네일 제작
	private boolean checkImageType(File file) {
		// MIME 타입을 통해 이미지 여부 확인
		// file.toPath() : 파일 객체를 path객체로 변환
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			logger.info("contentType : " + contentType );
			
			//MIME 타입 정보가 image로 시작하는지 여부를 return
			return contentType.startsWith("image");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}	
		return false;
	}
}
