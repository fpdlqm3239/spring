package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import xyz.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : 요청 처리 메소드의 뷰페이지에게만 제공되는 객체를 현재 컨트롤러의 모든 
//요청 처리 메소드와 뷰페이지에서 사용할 수 있도록 제공하는 어노테이션
// => Model 객체를 이용하여 객체를 저장한 경우 Request Scope가 아닌 Session Scope 사용
// => Session Scope를 사용하지만 현재 컨트롤러의 자원만 사용 가능
// => 변경 처리시 다른 요청 처리 메소드에서 필요한 정보를 전달하거나 검색하는 작업 생략
//value 속성 : Session Scope로 제공하가 위한 속성명을 속성값으로 설정
// => 다른 속성이 없는 경우 속성값만 설정 가능
@SessionAttributes("hewon")
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 반환하는 메소드 - Service 클래스의 메소드
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId("abc123");
		hewon.setPasswd("123456");
		hewon.setName("홍길동");
		hewon.setEmail("abc@itwill.xyz");
		hewon.setGender("남자");
		return hewon;
	}
	
	//아이디를 전달받아 회원정보를 검색하여 뷰페이지에 제공하는 요청 처리 메소드
	// => 회원정보를 제공받은 뷰페이지에서 회원정보 출력
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		//회원정보를 검색하여 반환받아 저장 - Service 클래스의 메소드 호출
		Hewon hewon=getHewon("abc123");
		
		//Model 객체를 이용하여 뷰페이지에 검색된 회원정보 제공 - Request Scope
		//model.addAttribute("hewon", hewon);
		//Model.addAttribute(Object attributeValue) : 뷰 페이지에 제공되는 객체의 속성명(attributeName)이
		//생략된 경우 객체(속성값)의 클래스명을 속성명으로 자동 설정 - 첫번째 문자는 소문자로 변환
		// => 기본형(Wrapper) 또는 String 클래스는 제외
		//@SessionAttributes 어노테이션에 의해 현재 컨트롤러의 모든 요청 처리 메소드와 
		//뷰페이지에서 사용되도록 제공 - Session Scope
		model.addAttribute(hewon);
		
		return "session/hewon_view";
	}
	
	/*
	//아이디를 전달받아 회원정보를 검색하여 뷰페이지에 제공하는 요청 처리 메소드
	// => 회원정보를 제공받은 뷰페이지에서 입력태그에 회원정보를 초기값으로 설정
	@RequestMapping(value = "/hewon_update",method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "session/hewon_update";
	}
	*/
	
	@RequestMapping(value = "/hewon_update",method = RequestMethod.GET)
	public String hewonUpdate(Model model) {
		return "session/hewon_update";
	}
	
	//회원정보를 전달받아 회원정보를 변경하는 요청 처리 메소드
	//@SessionAttributes 어노테이션에 의해 제공된 객체를 매개변수에 저장하고 전달값을 받아 필드값 변경
	//SessionStatus : @SessionAttributes 어노테이션에 의해 제공된 객체의 상태정보를 저장하는 객체
	@RequestMapping(value = "/hewon_update",method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon, SessionStatus status) {
		System.out.println("변경 아이디 = "+hewon.getId());
		
		//SessionStatus.setComplete() : @SessionAttributes 어노테이션에 의해 제공된 객체를 제거하는 메소드
		status.setComplete();
		
		return "session/hewon_view";
	}
}






