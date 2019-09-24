package novelComment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import novel.vo.NovelInfo;
import novelComment.dao.NovelCommentDao;
import novelComment.vo.NovelComment;

public class NovelCommentService {

	private NovelCommentDao ncDao = new NovelCommentDao();
	
	public ArrayList<NovelComment> selectList(int nno, int dno) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NovelComment> cList = ncDao.selectList(conn, nno, dno);
		
		JdbcUtil.close(conn);
		
		return cList;
	}
	
	public int insertComment(NovelComment nco) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int result = ncDao.insertComment(conn, nco);
		
		if(result > 0) JdbcUtil.commit(conn);
		else JdbcUtil.rollback(conn);
		
		JdbcUtil.close(conn);
		
		return result;
	}

}
