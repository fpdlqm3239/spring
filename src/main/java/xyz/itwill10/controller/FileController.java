package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

//파일 업로드
//1.commons-fileupload 라이브러리 빌드 처리 - pom.xml
//2.파일 업로드 기능을 제공하는 클래스를 Spring Bean으로 등록 - servlet-context.xml

@Controller
public class FileController {
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	//MultipartHttpServletRequest : "multipart/form-data"로 전달되는 값과 파일을 처리하기 위한 객체
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IOException {
		String uploadName=request.getParameter("uploadName");
		
		//MultipartHttpServletRequest.getFile(String parameterName) : 전달된 파일을 
		//MultipartFile 객체로 반환하는 메소드
		//MultipartFile : 전달된 파일의 정보를 저장하는 객체
		MultipartFile uploadFile=request.getFile("uploadFile");

		//전달파일에 대한 유효성 검사 : 파일 유무, 파일 형식, 파일 크기
		//MultipartFile.isEmpty() : 전달파일이 없는 경우 true를 반환하는 메소드
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//MultipartFile.getContentType() : 전달파일의 형식(MimeType)을 반환하는 메소드
		System.out.println("파일 형식 = "+uploadFile.getContentType());
		//MultipartFile.getBytes() : 전달파일을 byte 배열로 변환하여 반환하는 메소드
		System.out.println("파일 크기 = "+uploadFile.getBytes().length);
		
		//전달파일을 서버에 저장하기 위한 업로드 디렉토리에 시스템 경로를 반환받아 저장
		String uploadDir=request.getServletContext().getRealPath("/resources/images");
		
		//전달파일을 서버에 저장하기 위한 File 객체 생성
		//MultipartFile.getOriginalFilename() : 전달파일의 이름을 반환하는 메소드
		File file=new File(uploadDir, uploadFile.getOriginalFilename());
		
		//MultipartFile.transferTo(File file) : 전달파일을 서버에 저장하는 메소드
		// => 서버 업로드 디렉토리에 업로드 파일과 같은 이름의 파일이 있는 경우 덮어씌우기 하여 저장
		uploadFile.transferTo(file);//업로드 처리
		
		request.setAttribute("uploadName", uploadName);
		request.setAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	*/
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam String uploadName
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//WebApplicationContext 객체를 이용하여 서버 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDir=context.getServletContext().getRealPath("/resources/images");
		
		File file=new File(uploadDir, uploadFile.getOriginalFilename());
		
		uploadFile.transferTo(file);//업로드 처리
		
		model.addAttribute("uploadName", uploadName);
		model.addAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		return "file/file_upload";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getFile().isEmpty()) {//파일이 전달되지 않은 경우
			return "file/file_upload";
		}
		
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
		
		//전달파일명을 반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
		
		//업로드 파일명을 고유값(현재 시스템의 TimeStamp를 사용)로 설정하여 저장
		// => 업로드 파일명이 중복되지 않도록 설정
		String upload=System.currentTimeMillis()+"";
		
		//파일 업로드
		fileBoard.getFile().transferTo(new File(uploadDir, upload));
		
		//DTO 객체의 필드값 변경
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		//서버 디렉토리에 저장된 업로드 파일 삭제
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
		new File(uploadDir, fileBoard.getUpload()).delete();
		
		//FILEBOARD 테이블에 저장된 게시글 삭제
		fileBoardService.removeFileBoard(num);
		
		return "redirect:/file_list";
	}
	
	//요청 처리 메소드에서 요청 처리 후 다운로드 프로그램을 실행하여 응답
	// => 반환되는 문자열을 이용하여 프로그램 실행되도록 ViewResolver 설정 - servlet-context.xml
	@RequestMapping("/file_download/{num}")
	public String fileDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//다운로드 파일정보를 다운로드 프로그램(Spring Bean)에게 제공
		model.addAttribute("uploadDir", context.getServletContext().getRealPath("/WEB-INF/upload"));
		model.addAttribute("uploadFilename", fileBoard.getUpload());
		model.addAttribute("originFilename", fileBoard.getOrigin());
		
		//프로그램(Spring Bean)의 beanName 반환
		return "fileDownload";
	}
}











