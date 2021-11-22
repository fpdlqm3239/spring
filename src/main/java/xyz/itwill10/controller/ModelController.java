package xyz.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name", "홍길동");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display1";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "임꺽정");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display2";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "전우치");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display3";
	}
	
	//@ModelAttribute : 메소드에 선언한 어노테이션인 경우 현재 Controller 클래스에 선언된
	//모든 요청 처리 메소드의 뷰페이지에게 반환값(객체)을 사용하도록 제공하기 위한 어노테이션
	//value(name) 속성 : 뷰페이지에서 반환값을 사용하기 위한 속성명을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능 
	@ModelAttribute("now")
	public String getNow() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	}
}







