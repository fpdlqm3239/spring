package xyz.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.FileBoardDAO;
import xyz.itwill10.dto.FileBoard;

@Service
public class FileBoardServiceImpl implements FileBoardService {
	@Autowired
	private FileBoardDAO fileBoardDAO;

	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Override
	public void removeFileBoard(int num) {
		fileBoardDAO.deleteFileBoard(num);
	}

	@Override
	public FileBoard getFileBoard(int num) {
		return fileBoardDAO.selectFileBoard(num);
	}

	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}
}
