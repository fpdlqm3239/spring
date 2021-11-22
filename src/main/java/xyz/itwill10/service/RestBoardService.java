package xyz.itwill10.service;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardService {
	void addRestBoard(RestBoard board);
	void modifyRestBoard(RestBoard board);
	void removeRestBoard(int num);
	int getRestBoardCount();
	RestBoard getRestBoard(int num);
	List<RestBoard> getRestBoradList(Map<String, Object> map);
}
