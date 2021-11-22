package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//메일 전송 관련 메세지 기능을 제공하는 클래스 - Advice
public class EmailSendAdvice {
	//메일 전송 전 실행될 명령을 작성한 메소드 - Before Advice
	// => JoinPoint 매개변수로 타겟메소드(EmailSendBean 클래스의 sendEmail 메소드)의 
	//매개변수값을 이용하여 메세지 출력 기능 제공
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[메세지]<"+email+">님에게 <"+subject+"> 제목을 이메일을 전송합니다.");
	}
	
	//메일 전송이 성공한 후 실행될 명령을 작성한 메소드 - After Returning Advice
	// => 매개변수에 저장된 타겟메소드(EmailSendBean 클래스의 sendEmail 메소드)의 반환값을
	//이용하여 메세지 출력 기능 제공
	public void successMessage(String email) {
		System.out.println("[메세지]<"+email+">님에게 이메일을 성공적으로 전송 하였습니다.");
	}
	
	//메일 전송이 실패한 후 실행될 명령을 작성한 메소드 - After Throwing Advice
	// => 매개변수에 저장된 타겟메소드(EmailSendBean 클래스의 sendEmail 메소드)의 예외를
	//이용하여 메세지 출력 기능 제공
	public void failMessage(Exception exception) {
		System.out.println("[에러]이메일 전송 실패 = "+exception.getMessage());
	}
	
}





