package xyz.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice : 예외처리 메소드만 선언된 Controller 클래스에서 사용하는 어노테이션
// => 모든 컨트롤러의 요청 처리 메소드에서 발생되는 예외에 대한 처리 가능
@ControllerAdvice
public class ExceptionController {
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHander(Exception exception) {
		exception.printStackTrace();//예외를 콘솔에 기록
		return "userinfo/user_error";
	}
	*/
}
