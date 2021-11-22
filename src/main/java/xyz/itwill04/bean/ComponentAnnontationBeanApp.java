package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentAnnontationBeanApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanAnnotation.xml");
		System.out.println("========== Spring Container 초기화 후 ==========");		
		//ComponentAnnontationBean bean=context.getBean("componentAnnontationBean",ComponentAnnontationBean.class);
		ComponentAnnontationBean bean=context.getBean("bean",ComponentAnnontationBean.class);
		bean.display();
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
