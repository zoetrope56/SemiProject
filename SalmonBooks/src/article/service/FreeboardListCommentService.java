package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.FreeboardArticleCommentDao;
import article.model.FreeboardArticleComment;
import jdbc.connection.ConnectionProvider;

public class FreeboardListCommentService {
	private FreeboardArticleCommentDao commentDao = new FreeboardArticleCommentDao();
	public FreeboardCommentPage	getCommentPage(int commentCount, int no) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int nowCount = commentDao.selectCount(conn, no);
			List<FreeboardArticleComment> list = commentDao.select(conn, no, commentCount, nowCount);
			return new FreeboardCommentPage(list, nowCount);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
