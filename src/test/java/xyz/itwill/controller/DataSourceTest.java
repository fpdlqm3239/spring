package xyz.itwill.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Spring Framework를 이용하여 테스트 프로그램을 작성해 모듈(단위 프로그램) 테스트 하는 방법
//1.junit 라이브러리와 spring-test 라이브러리 빌드 처리 - pom.xml
// => scope 엘리먼트 제거 
//2.src/test/resources 폴더의 log4j.xml 변경
//3.src/test/java 폴더에 테스트 클래스 작성 - 테스트 메소드를 이용하여 모듈 테스트

//@RunWith : 테스트 메소드를 실행하기 위한 클래스(Clazz)를 설정하는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 테스트 클래스에서 사용할 Spring Bean이 등록된 Bean Configuration
//File을 설정하는 어노테이션
// => ApplicationContext 객체(Spring Container)에 의해 관리될 클래스를 Spring Bean으로 등록
//locations 속성 : Bean Configuration File 경로를 배열 형식의 속성값으로 설정
// => Bean Configuration File 경로는 file 접두사를 사용하여 설정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	private static final Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
	//필드에 DataSource 관련 클래스의 Spring Bean 객체로 인젝션 처리
	@Autowired
	private DataSource dataSource;
	
	//@Test : 테스트 메소드를 설정하는 어노테이션
	// => Runner 클래스에 의해 호출되어 실행되는 메소드
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+dataSource);
		logger.info("Connection = "+dataSource.getConnection());
	}
}














