package xyz.itwill06.oop;

public class OopOne {
	//메소드에 중복코드가 존재할 경우 중복코드 대신 사용될 메소드 선언
	// => 중복코드를 최소화 하여 유지보수의 효율성 증가
	/*
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
	}
	*/
	
	OopLogger logger=new OopLogger();
	
	public void display1() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1() 메소드 호출 ***");
	}
	
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 메소드 호출 ***");
	}
	
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 메소드 호출 ***");
	}
}
