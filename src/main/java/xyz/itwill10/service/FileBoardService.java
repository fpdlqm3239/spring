package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.FileBoard;

public interface FileBoardService {
	void addFileBoard(FileBoard fileBoard);
	void removeFileBoard(int num);
	FileBoard getFileBoard(int num);
	List<FileBoard> getFileBoardList();
}
