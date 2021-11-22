package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;

public interface PointBoardService {
	PointUser addPointBoard(PointBoard board);
	PointUser erasePointBoard(int num);
	List<PointBoard> getPointBoardList();
}
