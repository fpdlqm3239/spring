package xyz.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.itwill10.dao.PointBoardDAO;
import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;

@Service
public class PointBoardServiceImpl implements PointBoardService {
	@Autowired
	private PointBoardDAO pointBoardDAO;
	
	@Autowired
	private PointUserDAO pointUserDAO;

	//게시글 정보를 전달받아 POINTBOARD 테이블에 삽입하여 저장하고 작성자 정보를 반환하는 메소드
	// => 게시글 작성자를 전달하여 POINTUSER 테이블에 저장된 사용자의 포인트가 증가되도록 작성
	//@Transactional : 메소드에서 예외가 발생된 경우 예외 발생전 실행된 모든 SQL 명령을 롤백
	//처리하는 어노테이션 
	// => root-context 파일에 tx NameSpace의 annotation-driven 엘리먼트 설정
	// => INSERT, UPDATE, DELETE 명령 관련 DAO 클래스의 메소드를 호출하는 Service 클래스의 메소드에 설정
	@Transactional
	@Override
	public PointUser addPointBoard(PointBoard board) {
		pointBoardDAO.insertPointBoard(board);
		
		//게시글 작성자가 POINTUSER 테이블에 저장된 사용자가 아닌 경우 예외 발생 
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("게시글 작성자가 존재하지 않습니다.");
		}
		
		pointUserDAO.updatePlusPointUser(board.getWriter());
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//게시글 번호를 전달받아 POINTBOARD 테이블에 저장된 게시글을 삭제하고 작성자 정보를 반환하는 메소드
	// => 게시글 작성자를 전달하여 POINTUSER 테이블에 저장된 사용자의 포인트가 감소되도록 작성
	@Transactional
	@Override
	public PointUser erasePointBoard(int num) {
		PointBoard board=pointBoardDAO.selectPointBoard(num);
		//삭제할 게시글이 존재하지 않는 경우 예외 발생
		if(board==null) {
			throw new RuntimeException("게시글이 존재하지 않습니다.");
		}
		
		pointBoardDAO.deletePointBoard(num);
		
		pointUserDAO.updateMinusPointUser(board.getWriter());
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//POINTBOARD 테이블에 저장된 모든 게시글을 검색하여 반환하는 메소드
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}
}
