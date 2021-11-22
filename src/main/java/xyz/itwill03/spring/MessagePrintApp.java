package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container로 객체를 생성하여 제공받아 사용
// => 개발자가 아닌 Spring Container가 객체 관리 - Spring IoC
// => Spring Bean Configuration File(XML)를 이용하여 객체 생성과 객체간의 의존관계 설정
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);//포함관계(의존관계) 성립
		print.messagePrint();
		*/
		
		//ApplicationContext 객체(Spring Container) 생성
		// => Spring Bean Configuration File을 제공받아 Spring Bean를 생성하여 관리
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container가 관리하는 Spring Bean(객체)를 제공받아 저장
		// => bean 엘리먼트의 식별자(beanName)를 전달하여 Spring Container로부터 Spring Bean 반환
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		//Spring Container 제거 - Spring Container가 관리하는 모든 Spring Bean 제거
		((ClassPathXmlApplicationContext)context).close();
	}
}













