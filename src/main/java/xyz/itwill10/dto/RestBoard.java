package xyz.itwill10.dto;

//create table rest_board(num number primary key, writer varchar2(20), content varchar2(100), regdate date);
//create sequence rest_board_seq;   
public class RestBoard {
	private int num;
	private String writer;
	private String content;
	private String regdate;

	public RestBoard() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
