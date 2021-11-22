package xyz.itwill10.exception;

import xyz.itwill10.dto.Userinfo;

//회원등록시 사용자가 입력한 아이디가 이미 존재하는 경우를 위해 작성된 예외클래스
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//예외 처리시 필요한 값을 저장하기 위한 필드
	// => 사용자가 입력한 회원정보를 저장하기 위한 필드
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoExistsException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
}
