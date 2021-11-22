package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

//SpringMVC에서 Mybatis Framework를 이용하여 DAO 클래스를 작성하는 방법
//1.DataSource 관련 라이브러리와 Mybatis 관련 라이브러리 빌드 처리 - pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybatis Framework의 환경설정파일 작성
//3.SqlSessionFactory 관련 클래스와 SqlSession 관련 클래스를 Spring Bean으로 등록
// => Bean Configuration File(root-context.xml)에서 bean 엘리먼트 사용
//4.DTO 클래스 작성
//5.Mapper 작성 - XML 맵퍼 파일과 Interface 맵퍼 파일을 바인딩하여 작성
//6.DAO 클래스 작성 - Mapper에 등록된 SQL 명령을 전달하여 실행하고 결과를 제공받아 반환

//Mybatis Framework에서 제공되는 로그를 Spring 로그 구현체로 기록되도록 설정하는 방법
//1.log4jdbc-log4j2-jdbc4 라이브러리 빌드 처리 - pom.xml
//2.DataSource 관련 클래스를 Spring Bean으로 등록하는 엘리먼트에서 driverClassName 필드와
//url 필드를 log4jdbc-log4j2-jdbc4 라이브러리에서 제공되는 값으로 인젝션 처리 - root-context.xml
//3.src/main/resources 폴더에 log4jdbc.log4j2.properties 파일 작성
//4.log4j.xml 파일에서 로그 이벤트에 대한 기록 설정

//DAO 클래스 : 저장매체에게 행에 대한 삽입,변경,삭제,검색 기능을 제공하는 클래스
// => DBMS 서버에 SQL 명령을 전달하여 실행한 결과를 Java 자료형의 객체로 반환하는 기능의 메소드 작성

//@Repository : DAO 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => 트렌잭션 매니저 관련 기능을 제공받아 사용
//Spring Container가 Spring 어노테이션을 처리하기 위해 Bean Configuration File(servlet-context.xml)에서
//component-scan 엘리먼트를 사용하여 DAO 클래스가 작성된 패키지 지정
@Repository
public class StudentDAOImpl implements StudentDAO {
	//SqlSession 관련 클래스로 등록된 Spring Bean 객체를 필드에 인젝션 처리
	// => DAO 클래스의 메소드에서 SqlSession 객체로 메소드 호출 가능
	//@Autowired 어노테이션과 @Qualifier 어노테이션을 사용하여 인젝션 처리
	// => 필드마다 어노테이션을 이용하여 인젝션 처리
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}

}
