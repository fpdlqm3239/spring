package xyz.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//메일 전송 기능을 제공하는 클래스
public class EmailSendBean {
	//메일을 전송하는 JavaMailSender 객체를 저장하는 필드
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	//메일을 전송하는 메소드 - 핵심관심모듈
	// => 받는 사람 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	// => 받는 사람 이메일 주소 반환 - 메세지 출력
	public String sendEmail(String email, String subject, String content) {
		//JavaMailSender.createMimeMessage() : MimeMessage 객체를 반환하는 메소드
		//MimeMessage : 메일 전송 관련 정보를 저장하기 위한 객체
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			//MimeMessage.setSubject(String subject) : MimeMessage 객체의 메일 제목을 변경하는 메소드
			message.setSubject(subject);
			
			//MimeMessage.setText(String content) : MimeMessage 객체의 메일 내용(텍스트)을 변경하는 메소드
			message.setText(content);
			
			//MimeMessage.setRecipients(RecipientType type, InternetAddress email) 
			// => MimeMessage 객체의 메일을 받는 사용자에 대한 정보를 변경하는 메소드
			// => 받는 사람의 이메일 주소는 InternetAddress 객체 대신 문자열(String) 가능
			//InternetAddress.parse(String email) : 문자열을 전달받아 InternetAddress 객체로 변환하여 반환하는 메소드
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			//JavaMailSender.send(MimeMessage message) : JavaMailSender 객체로 메일을 전송하는 메소드
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return email;
	}
}