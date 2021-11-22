package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	//타겟메소드의 명령이 실행되는 처리시간(ms)를 계산하여 기록하는 메소드 - Around Advice
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//타겟메소드 실행 전 동작될 명령 작성
		//System.currentTimeMillis() : 시스템의 현재 타임스템프를 반환하는 메소드
		// => 타임스템프(TimeStamp) : 날짜와 시간을 정수(long)로 표현하기 위한 값
		long beginTime=System.currentTimeMillis();
		
		Object object=joinPoint.proceed();//타겟메소드 호출 - 타겟메소드의 명령 실행

		//타겟메소드 실행 후 동작될 명령 작성
		long endTime=System.currentTimeMillis();

		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		logger.info(className+" 클래스의 "+methodName+" 메소드 실행 시간 = "
			+(endTime-beginTime)+"ms");
		
		return object;
		*/
		
		//StopWatch : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : 시간 측정을 시작하는 메소드
		stopWatch.start();
		
		Object object=joinPoint.proceed();//타겟메소드 호출 - 타겟메소드의 명령 실행
		
		//StopWatch.stop() : 시간 측정을 종료하는 메소드
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		//StopWatch.getTotalTimeMillis() : 측정된 시간(ms)을 반환하는 메소드
		logger.info(className+" 클래스의 "+methodName+" 메소드 실행 시간 = "
				+stopWatch.getTotalTimeMillis()+"ms");
		
		return object;
	}
}
 










