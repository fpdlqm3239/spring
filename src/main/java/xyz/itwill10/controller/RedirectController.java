package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print")
	public String forward(Model model) {
		//뷰페이지에서 사용할 객체 제공 - Request Scope
		model.addAttribute("name", "홍길동");
		
		//ViewName 반환 >> 뷰페이지(JSP)로 포워드 이동
		//포워드 이동 : 서버측에서 다른 웹프로그램(JSP)으로 스레드를 이동하여 응답 처리
		// => 클라이언트의 요청 URL 주소 미변경, Request Scope로 제공되는 객체 사용 가능
		return "movement/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		return "movement/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//반환되는 ViewName에 redirect 접두사(NameSpace)를 사용하면 리다이렉트 이동
		// => ViewName에 의해 뷰페이지(JSP)로 응답하는 대신 클라이언트에게 URL 주소 전달
		//리다이렉트 이동 : 클라이언트에게 URL 주소를 전달하여 재요청하여 응답 처리
		// => 클라이언트의 요청 URL 주소 변경, Request Scope로 제공되는 객체 사용 불가능
		return "redirect:/redirect_print";
	}
	*/
	
	@RequestMapping("/redirect_print")
	public String redirect() {
		return "movement/redirect_display";
	}
	
	//RedirectAttributes : 리다이렉트 이동에 의해 호출되는 요청 처리 메소드의 뷰페이지에게
	//속성값을 제공하기 위한 객체
	@RequestMapping("/redirect")
	public String redirect(/* Model model*/ RedirectAttributes attributes) {
		//model.addAttribute("name", "임꺽정");
		
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => 리다이렉트 이동에 의해 호출되는 요청 처리 메소드의 뷰페이지에게 제공될 속성값을 저장하는 메소드
		attributes.addFlashAttribute("name", "임꺽정");
		
		return "redirect:/redirect_print";
	}

}
