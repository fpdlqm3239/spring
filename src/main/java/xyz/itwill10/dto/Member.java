package xyz.itwill10.dto;

//JavaBean 클래스 : 전달값을 저장하기 위한 클래스
// => DAO 클래스에서 사용할 경우 DTO 클래스의 기능 수행
//전달값의 이름과 동일한 이름의 필드 선언 - 전달값이 필드에 자동 저장 : Setter 메소드
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
