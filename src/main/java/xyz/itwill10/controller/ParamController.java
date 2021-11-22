package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	//요청 처리 메소드에 HttpServletRequest 자료형의 매개변수를 선언하면 클라이언트의
	//요청정보(리퀘스트 메세지 - HttpServletRequest 객체)를 자동으로 제공받아 저장
	// => HttpServletRequest 객체를 이용하여 전달값을 반환받아 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//전달값의 이름과 동일한 이름의 매개변수(String)를 선언하면 자동으로 전달값이 매개변수에 저장되어 제공
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam : 전달값을 매개변수에 저장하기 위한 어노테이션
	// => 매개변수의 이름과 같은 이름의 전달값이 없는 경우 400 에러 발생
	// => 매개변수에 반드시 전달값이 저장되도록 사용하는 어노테이션
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam 어노테이션의 value 속성을 사용하여 전달값의 이름에 대한 설정 가능
	//value 속성 : 전달값의 이름을 속성값으로 설정
	// => 전달값의 이름과 매개변수의 이름이 다른 경우 사용
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	//required 속성 : false(전달값 미필수) 또는 true(전달값 필수 - 기본) 중 하나를 속성값으로 설정
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value = "username", required = true) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	//defaultValue 속성 : 전달값이 없어 매개변수에 아무런 값도 저장하지 않을 경우 매개변수에
	//저장된 기본값을 속성값으로 설정
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value = "username", defaultValue = "임꺽정") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
}
