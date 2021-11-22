package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@FixMethodOrder : 테스트 메소드의 호출순서를 설정하는 어노테이션
//value 속성 : MethodSorters 자료형(Enum)의 상수 중 하나를 속성값으로 설정
// => MethodSorters.DEFAULT : 테스트 메소드의 해쉬코드(메모리 주소)를 이용하여 호출순서 설정 - 호출순서 불확실
// => MethodSorters.JVM : 테스트 메소드를 JVM이 불러온 순서대로 호출순서 설정 - 호출순서 불확실
// => MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름으로 호출순서 설정 - 호출순서 확실
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		//board.setWriter("abc");
		//게시글 작성자가 없는 경우 예외 발생 
		//문제점)예외 발생전에 실행된 게시글 저장 관련 SQL 관련 명령 처리
		//해결법)예외가 발생되기 전에 실행된 SQL 명령 취소(ROLLBACK) 처리 - TransactionManager 이용
		board.setWriter("xxx");
		board.setSubject("테스트");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
	}
	
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		
		if(boardList.isEmpty()) {
			logger.info("저장된 게시글이 하나도 없습니다.");
		} else {
			for(PointBoard board:boardList) {
				logger.info("글번호 = "+board.getNum()+", 작성자 =  "+board.getWriter()
						+", 제목 = "+board.getSubject());
			}
		}
	}
	
	/*
	@Test
	public void testErasePointBoard() {
		PointUser user=pointBoardService.erasePointBoard(1);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
	}
	*/
}