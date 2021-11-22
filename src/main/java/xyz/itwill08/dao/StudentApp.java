package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("============================================================================");
		StudentService service=context.getBean("studentService", StudentService.class);

		/*
		Student student=new Student();
		student.setNo(8000);
		student.setName("곽재우");
		student.setPhone("010-1231-7845");
		student.setAddress("서울시 동작구");
		student.setBirthday("2003-05-19");
		service.addStudent(student);
		*/
		
		/*
		Student student=service.getStudent(8000);
		student.setName("고길동");
		student.setBirthday("2002-06-06");
		service.modifyStudent(student);
		*/
		
		service.removeStudent(8000);
				
		List<Student> studentList=service.getStudentList();
		for(Student stu:studentList) {
			System.out.println(stu.getNo()+", "+stu.getName()+", "+stu.getPhone()
					+", "+stu.getAddress()+", "+stu.getBirthday().substring(0,10));
		}
		System.out.println("============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
