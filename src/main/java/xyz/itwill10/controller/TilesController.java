package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Tiles : 템플릿 페이지를 이용한 사이트 구현을 제공하는 프로그램
//1.Tiles 관련 라이브러리를 빌드 처리 - pom.xml
//2.요청 처리 메소드에서 반환되는 ViewName를 Tiles 프로그램으로 응답되도록 ViewResolver 설정 - servlet-context.xml
//3.Tiles Configuration File(tiles.xml) 작성 - 요청 처리 메소드에서 반환되는 ViewName에 대한 응답 템플릿 페이지(JSP) 설정
@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
	
	@RequestMapping("/admin")
	public String tilesAdmin() {
		return "admin";
	}
	
	@RequestMapping("/admin/member")
	public String tilesAdminMember() {
		return "admin/member_manager";
	}
}
