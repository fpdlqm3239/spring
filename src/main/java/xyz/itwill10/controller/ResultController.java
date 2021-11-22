package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//요청 처리 메소드의 처리결과를 뷰페이지(JSP)에게 제공하는 방법
//1.ModelAndView 객체에 처리결과를 속성값으로 저장하여 제공
// => 요청 처리 메소드는 반드시 ModelAndView 객체 반환
//2.HttpServletRequest 객체에 처리결과를 속성값으로 저장하여 제공
//3.Model 객체에 처리결과를 속성값으로 저장하여 제공

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");//ViewName 저장
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => 뷰페이지에서 사용 가능하도록 처리결과(객체)를 저장하는 메소드 - Request Scope
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}
	*/
	
	//요청 처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	// => 요청 처리 메소드에 매개변수를 작성하면 Spring Container로부터 Spring Bean 객체를 
	//제공받아 매개변수에 자동으로 저장
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "임꺽정");
		return "result_display";
	}
	
	//Model : 처리결과를 저장하기 위한 객체
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model.addAttribute(String attributeName, Object attributeValue)
		// => 뷰페이지에서 사용 가능하도록 처리결과(객체)를 저장하는 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
}







