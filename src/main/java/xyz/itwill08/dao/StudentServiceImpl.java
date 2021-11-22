package xyz.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	//Bean Configuration File에서 StudentServiceImpl 클래스를 Spring Bean으로 등록할 때
	//StudentDAOImpl 클래스의 Spring Bean을 필드에 인젝션하여 의존관계 설정 - DI(Dependency Injection)
	// => 부모 인터페이스를 필드의 자료형으로 선언하면 모든 자식클래스의 객체 저장
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
