package xyz.itwill10.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.itwill10.dao.RestBoardDAO;
import xyz.itwill10.dto.RestBoard;

@Service
public class RestBoardServiceImpl implements RestBoardService {
	@Autowired
	private RestBoardDAO restBoardDAO;

	@Transactional
	@Override
	public void addRestBoard(RestBoard board) {
		restBoardDAO.insertRestBoard(board);
	}

	@Transactional
	@Override
	public void modifyRestBoard(RestBoard board) {
		/*
		if(restBoardDAO.selectRestBoard(board.getNum())==null) {
			throw new Exception("변경하고자 하는 게시글이 존재하지 않습니다.");
		}
		*/
		restBoardDAO.updateRestBoard(board);
	}

	@Transactional
	@Override
	public void removeRestBoard(int num) {
		restBoardDAO.deleteRestBoard(num);
	}

	@Override
	public int getRestBoardCount() {
		return restBoardDAO.selectRestBoardCount();
	}

	@Override
	public RestBoard getRestBoard(int num) {
		return restBoardDAO.selectRestBoard(num);
	}

	@Override
	public List<RestBoard> getRestBoradList(Map<String, Object> map) {
		return restBoardDAO.selectRestBoardList(map);
	}
}
