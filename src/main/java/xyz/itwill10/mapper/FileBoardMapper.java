package xyz.itwill10.mapper;

import java.util.List;

import xyz.itwill10.dto.FileBoard;

public interface FileBoardMapper {
	int insertFileBoard(FileBoard fileBoard);
	int deleteFileBoard(int num);
	FileBoard selectFileBoard(int num);
	List<FileBoard> selectFileBoardList();
}
