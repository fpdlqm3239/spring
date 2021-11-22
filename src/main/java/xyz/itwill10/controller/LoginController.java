package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Member;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login_form";
	}
	
	/*
	//요청 처리 메소드에 HttpSession 클래스를 자료형으로 하는 매개변수를 선언하면 
	//세션 바인딩하여 HttpSession 객체를 매개변수에 저장하여 제공 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, Model model, HttpSession session) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//인증 실패
			//Request Scope : 요청 처리 메소드와 뷰페이지(JSP)에서만 속성값 사용 가능
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			model.addAttribute("id", id);
			return "session/login_form";
		}
		
		//Session Scope : 모든 요청 처리 메소드와 뷰페이지(JSP)에서 속성값 사용 가능
		session.setAttribute("loginId", id);
		return "session/login_result";
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, Model model, HttpSession session) {
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) {//인증 실패
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "session/login_form";
		}
		
		session.setAttribute("loginId", member.getId());
		return "session/login_result";
	}
}




