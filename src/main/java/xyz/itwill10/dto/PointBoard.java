package xyz.itwill10.dto;

//create table pointboard(num number primary key, writer varchar2(20),subject varchar2(100));
//create sequence pointboard_seq;
public class PointBoard {
	private int num;
	private String writer;
	private String subject;
	
	public PointBoard() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
