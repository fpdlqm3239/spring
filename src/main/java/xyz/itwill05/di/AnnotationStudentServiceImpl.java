package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component

//@Service : Service 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//=> 기본적으로 클래스명을 beanName으로 설정하며 value 속성을 사용하여 beanName 변경 가능
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Autowired : 필드에 Spring Bean 객체로 의존관계를 자동으로 설정하는 기능을 제공하는 어노테이션
	// => 필드의 Setter 메소드를 선언하지 않아도 Setter Injection 기능 제공
	// => bean 엘리먼트에 autowire 속성의 [byType] 속성값과 동일한 방법으로 의존관계 설정
	//문제점)필드의 자료형이 인터페이스라면 자식클래스로 Spring Bean이 여러개인 등록된 경우
	//의존관계를 설정할 때 NoUniqueBeanDefinitionException 발생
	//해결법-1)Spring Bean으로 등록된 자식클래스 중 하나의 beanName를 필드명과 같은 이름으로 변경 
	// => 자식클래스의 Spring Bean이 여러개 등록된 경우 autowrie 속성의 [byName] 속성값과 같은 방법으로 의존관계 설정
	//해결법-2)@Qualifier 어노테이션를 사용하여 의존관계를 설정할 Spring Bean를 선택
	//@Qualifier : 의존관계를 설정하고자 하는 Spring Bean을 선택하기 위한 어노테이션
	// => @Autowired 어노테이션의 종속된 어노테이션
	// => 의존관계를 설정할 Spring Bean의 beanName을 value 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
	@Autowired
	//@Qualifier("annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	//@Resource : Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	// => JDK 라이브러리에 의해 제공되는 어노테이션 - 다른 Framework에서 사용 가능
	// => 기본적으로 [byName]으로 의존관계 설정
	//@Inject : Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	// => JDK 라이브러리에 의해 제공되는 어노테이션 - 다른 Framework에서 사용 가능
	// => 기본적으로 [byType]으로 의존관계 설정
	private StudentDAO studentDAO;
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}

}
