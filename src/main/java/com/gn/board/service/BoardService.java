package com.gn.board.service;

import static com.gn.commom.sql.JDBCTemplate.close;
import static com.gn.commom.sql.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	public int createBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDao().createBoard(b,conn);
		close(conn);
		return result;
	}
}
	