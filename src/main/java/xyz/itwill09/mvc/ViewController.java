package xyz.itwill09.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=new Member("xxx", "¿œ¡ˆ∏≈");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("member", member);
		modelAndView.setViewName("member_view");
		
		return modelAndView;
	}

}
