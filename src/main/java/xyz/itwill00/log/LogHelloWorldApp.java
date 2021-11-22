package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorldApp {
	//Logger : 로그 구현체에서 기록을 전달하기 위한 인스턴스
	//LoggerFactory : Logger 인스턴스를 제공하기 위한 클래스
	//LoggerFactory.getLogger(Class<T> clazz) : 메모리에 저장된 클래스(Clazz)에서 발생된
	//기록을 로그 구현체에게 전달하는 Logger 인스턴스를 반환하는 메소드
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
	
	public static void main(String[] args) {
		//Logger.info(String message) : 로그 이벤트를 발생하여 로그 구현체에게 메세지를 
		//전달하는 메소드
		logger.info("시작");
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
	}
}
