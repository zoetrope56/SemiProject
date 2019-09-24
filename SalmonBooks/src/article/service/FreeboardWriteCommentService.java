package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.dao.FreeboardArticleCommentDao;
import article.dao.FreeboardArticleDao;
import article.model.FreeboardArticleComment;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class FreeboardWriteCommentService {
	private FreeboardArticleCommentDao commentDao = new FreeboardArticleCommentDao();
	public Integer write(FreeboardCommentWriteRequest fcwr) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			FreeboardArticleComment comment = toComment(fcwr);
			FreeboardArticleComment savedComment = commentDao.insert(conn, comment);
			if(savedComment == null) {
				throw new RuntimeException("fail to inser article_comment");
			}
			conn.commit();
			return savedComment.getArticleNo();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}
		finally {
			JdbcUtil.close(conn);
		}
	}
	private FreeboardArticleComment toComment(FreeboardCommentWriteRequest fcwr) {
		Date now = new Date();
		return new FreeboardArticleComment(null, fcwr.getArticleNo(), fcwr.getWriter().getId(), now, now, fcwr.getContent());
	}
}
