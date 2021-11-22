package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect : Spring Bean으로 등록된 클래스의 메소드에 Aspect 기능을 제공하기 위한 어노테이션
// => Bean Configuration File의 aspect 엘리먼트와 유사한 기능 제공
@Aspect
public class AopAnnotationAdvice {
	private static final Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class);
	
	//@Pointcut : 핵심관심모듈을 타겟메소드로 설정하기 위한 어노테이션
	// => Bean Configuration File의 pointcut 엘리먼트와 유사한 기능 제공
	// => Pointcut에 대한 재사용을 위해 설정
	// => 메소드명과 매개변수가 Pointcut 식별자로 사용되며 메소드 호출 형식으로 Pointcut 사용
	//value 속성 : 타겟메소드를 설정하기 위한 정보(execution 또는 within)을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	//@Before : Before Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 before 엘리먼트와 유사한 기능 제공
	//value 속성 : 타겟메소드를 설정하기 위한 정보(execution 또는 within)을 속성값으로 설정 - Pointcut
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	// => @Pointcut 어노테이션으로 설정된 메소드를 호출하여 타겟메소드 지정
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut())")
	public void beforeLog() {
		logger.info("[before]핵심관심코드 동작 전 삽입되어 실행될 횡단관심코드");
	}

	//@AfterReturning : After Returning Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 after-returning 엘리먼트와 유사한 기능 제공
	//returning 속성 : 타겟메소드의 반환값을 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterReturning(value = "aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning]핵심관심코드가 정상적으로 동작 후 삽입되어 실행될 횡단관심코드");
	}
	
	//@AfterThrowing : After Throwing Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 throwing 엘리먼트와 유사한 기능 제공
	//throwing 속성 : 타겟메소드에서 발생된 예외를 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterThrowing(value = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing]핵심관심코드 동작시 예외가 발생된 후 삽입되어 실행될 횡단관심코드");
	}
	
	//@After : After Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 after 엘리먼트와 유사한 기능 제공
	@After("aopPointCut())")
	public void afterLog() {
		logger.info("[after]핵심관심코드 동작 후 무조건 삽입되어 실행될 횡단관심코드");
	}
	
	//@Around : Around Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 around 엘리먼트와 유사한 기능 제공
	@Around("aopPointCut())")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심코드 동작 전 삽입되어 실행될 횡단관심코드");
		Object object=joinPoint.proceed();
		logger.info("[around]핵심관심코드 동작 후 삽입되어 실행될 횡단관심코드");
		return object;
	}
}
