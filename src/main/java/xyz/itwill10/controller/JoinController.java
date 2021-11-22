package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}

	/*
	//전달값의 이름과 같은 이름의 매개변수를 작성하여 전달값 저장
	//@RequestParam 어노테이션을 사용하여 매개변수의 이름과 같은 이름의 전달값이 없는 경우 400 에러 발생
	// => values 속성을 이용하여 매개변수와 다른 이름의 전달값을 제공받아 매개변수에 저장 가능
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute 어노테이션을 매개변수에 선언한 경우 매개변수에 저장된 값을 요청 처리
	//메소드의 뷰페이지에 자동으로 제공
	// => 매개변수의 이름과 같은 이름이 전달값이 없어도 400 에러 미발생
	// => 매개변수의 자료형이 기본형(Wrapper) 또는 문자열(String)인 경우 value 속성을 반드시 설정
	//value 속성 : 뷰페이지에게 매개변수에 저장된 값을 제공하는 속성명을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value="id") String id
			, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name
			, @ModelAttribute("email") String email) {
		return "join_display";
	}
	*/
	
	/*
	//요청 처리 메소드의 매개변수 자료형을 JavaBean 클래스로 선언한 경우 JavaBean 객체를
	//생성하여 전달값을 필드에 자동으로 저장하여 제공 - Command 객체
	//Command 객체 : 전달값을 필드에 저장한 객체로 매개변수에 자동 저장되고 뷰페이지에서 
	//사용되도록 제공하는 객체
	// => 전달값은 동일한 이름의 필드에 저장
	// 뷰페이지에 Command 객체가 제공되도록 @ModelAttribute 어노테이션을 사용하여 선언
	// => @ModelAttribute 어노테이션을 작성하지 않아도 자동 처리
	// => value 속성이 생략된 경우 클래스명을 속성명으로 자동 설정 - 첫문자는 소문자로 변환
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) {//아이디가 중복된 경우
			model.addAttribute("message", "이미 사용중인 아이디입니다.");
			return "join_form";
		}
		return "join_display";
	}
}











