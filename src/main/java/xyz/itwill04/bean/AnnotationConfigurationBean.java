package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : Spring Container가 관리하기 위한 클래스를 Spring Bean으로 등록하기 위한
//기능을 제공하는 환경설정 클래스를 구현하기 위한 어노테이션
// => Bean Configuration File의 beans 엘리먼트와 유사한 기능을 제공
@Configuration
public class AnnotationConfigurationBean {
	//@Bean : Spring Container가 관리하기 위한 클래스를 Spring Bean으로 등록하는 어노테이션
	// => Spring Bean으로 등록하기 위한 클래스를 객체로 생성하여 반환하는 메소드에 설정
	// => Bean Configuration File의 bean 엘리먼트와 유사한 기능을 제공
	// => 기본적으로 메소드명을 beanName으로 사용
	// => @Bean 어노테이션의 name 속성을 사용하면 beanName 변경 가능
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}
