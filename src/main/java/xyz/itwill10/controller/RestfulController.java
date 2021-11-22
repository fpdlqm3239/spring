package xyz.itwill10.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill10.dto.Member;

//REST(RePresentation State Transfer) 기능을 제공하는 컨트롤러
//REST : 클라이언트 요청에 대한 요청 처리 메소드에서 요청 처리 후 처리 결과를 리소스
//(TEXT, XML, JSON 등)로 응답하는 기능
// => 다양한 기기의 요청에 대해 공통적으로 처리 가능한 텍스트 데이타로 응답하는 것이 목적인 웹프로그램
// => 사이트를 구현할 때 AJAX 기능으로 요청하고 응답결과를 JSON으로 제공받아 DHTML로 페이지 변환
@Controller
public class RestfulController {
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name,Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/
	
	//@ResponseBody : 요청 처리 메소드의 반환값(문자열)을 클라이언트에게 직접 응답되도록 설정하는 어노테이션
	// => 문자열(String)로만 응답 가능 - Java 자료형의 객체는 응답 불가능
	//@RequestBody : POST, PUT, PATCH, DELETE 등의 요청에 의해 전달된 모든 값을 JSON 형식의
	//텍스트 데이타(Object 객체)로 전달받아 저장하기 위한 어노테이션
	// => 전달값 : 이름=값&이름=값&... >> Object 객체 : {이름:값,이름:값,...}
	// => GET 방식으로 요청하여 전달된 값은 매개변수에 저장 불가능
	// => AJAX 요청에 의해 전달된 값을 저장하기 위해 사용
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		return input;
	}
	
	//회원정보를 JSON 형식의 텍스트 데이타로 응답하는 요청 처리 메소드
	// => 문자열이 아닌 Java 자료형의 객체로 응답할 경우 406 에러 발생
	//Java 자료형의 객체를 JSON 형식의 텍스트 데이타(문자열)로 자동 변환하여 응답되도록 설정
	// => jackson-databind 라이브러리 빌드 처리 - pom.xml
	@RequestMapping("/rest_member")
	@ResponseBody
	public Member restMember() {
		Member member=new Member();
		member.setId("abc123");
		member.setPasswd("123456");
		member.setName("홍길동");
		member.setEmail("abc@itwill.xyz");
		
		return member;		
	}
	
	@RequestMapping("/rest_memberList")
	@ResponseBody
	public List<Member> restMemberList() {
		List<Member> memberList=new ArrayList<Member>();
		
		Member member1=new Member();
		member1.setId("abc123");
		member1.setPasswd("123456");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		memberList.add(member1);
		
		Member member2=new Member();
		member2.setId("xyz789");
		member2.setPasswd("789123");
		member2.setName("임꺽정");
		member2.setEmail("xyz@itwill.xyz");
		memberList.add(member2);
		
		return memberList;
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	//매개변수의 자료형을 Map으로 선언하면 모든 전달값을 Map 객체의 엔트리(Key:이름,Value:전달값)로 
	//제공받아 저장 - @RequestParam 어노테이션을 반드시 사용하여 선언
	// => JavaBean(DTO) 클래스가 없는 경우 Map 객체를 이용하여 전달값을 제공 받거나 응답 처리 
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> output(@RequestParam Map<String,String> map) {
		return map;
	}
}








