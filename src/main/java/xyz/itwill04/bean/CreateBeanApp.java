package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Container로부터 Spring Bean를 제공받아 사용하는 방법
// => Bean Configuration File(XML)의 bean 엘리먼트를 이용하여 클래스를 Spring Bean으로 등록
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("방법-1.ApplicationContext 인터페이스를 상속받은 클래스로 생성된 Spring Container");
		//Spring Container 생성 전 - Bean Configuration File 읽기 전 
		System.out.println("========== Spring Container 초기화 전 ==========");
		//ApplicationContext : Spring Container 기능을 제공하기 위한 객체
		// => Bean Configuration File의 bean 엘리먼트에 등록된 모든 클래스를 미리 객체로 생성하여 관리
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		//Spring Container 생성 후 - Bean Configuration File 읽은 후 
		System.out.println("========== Spring Container 초기화 후 ==========");
		//DL(Dependency Lookup) : Spring Container에게 필요한 Spring Bean를 검색하여 제공받는 기능
		//ApplicationContext.getBean(String beanName) : beanName를 전달하여 Spring Container로부터
		//Spring Bean를 검색하여 반환하는 메소드
		// => Object 타입으로 Spring Bean를 반환하므로 명시적 객체 형변환하여 사용
		// => 전달받은 beanName의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)context.getBean("createBean");
		bean1.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 객체를 제거하는 메소드
		// => Spring Container가 관리하는 모든 Spring Bean 제거
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===============================================");
		System.out.println("방법-2.BeanFactory 인터페이스를 상속받은 클래스로 생성된 Spring Container");
		System.out.println("========== Spring Container 초기화 전 ==========");
		//BeanFactory : Spring Container 기능을 제공하기 위한 객체
		// => Bean Configuration File의 bean 엘리먼트에 등록된 클래스로 미리 객체로 생성하지
		//않고 getBean() 메소드 호출시 생성
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("========== Spring Container 초기화 후 ==========");
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		System.out.println("===============================================");
	}
}








