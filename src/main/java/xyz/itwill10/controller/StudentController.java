package xyz.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

//Controller 클래스 : 클라이언트의 요청을 처리하기 위한 기능을 제공하는 클래스
// => 요청 처리 메소드에서는 Service 클래스의 메소드를 호출하여 요청 처리

//@Controller : Controller 클래스를 Spring Bean으로 등록하는 어노테이션
// => 클라이언트 요청에 대한 처리 기능을 제공받아 사용
//Spring Container가 Spring 어노테이션을 처리하기 위해 Bean Configuration File(servlet-context.xml)에서
//component-scan 엘리먼트를 사용하여 Controller 클래스가 작성된 패키지 지정
@Controller
//@RequestMapping 어노테이션을 클래스에 선언하면 모든 요청 처리 메소드의 요청 URL 주소 앞부분에
//공통적으로 포함되는 URL 주소 설정 가능
@RequestMapping("/student")
public class StudentController {
	//Service 클래스로 등록된 Spring Bean 객체를 필드에 인젝션 처리
	// => 요청 처리 메소드에서 Service 객체로 메소드 호출 가능
	@Autowired
	private StudentService studentService;
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			//PK 제약조건이 설정된 컬럼에 중복된 값이 전달될 경우 예외 발생
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학번을 입력 하였습니다.");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	
	//@RequestMapping("/student/display")
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
}
