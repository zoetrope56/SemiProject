package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleCommentDao;
import reviewboard.article.model.ReviewBoardArticleComment;

public class ReviewBoardWriteCommentService {
	private ReviewBoardArticleCommentDao commentDao =new ReviewBoardArticleCommentDao();
	public Integer write(ReviewBoardCommentWriteRequest fcwr) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			ReviewBoardArticleComment comment = toComment(fcwr);
			ReviewBoardArticleComment savedComment = commentDao.insert(conn, comment);
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

	private ReviewBoardArticleComment toComment(ReviewBoardCommentWriteRequest fcwr) {
		Date now = new Date();
		return new ReviewBoardArticleComment(null, fcwr.getArticleNo(), fcwr.getWriter().getId(), now, now, fcwr.getContent());
	}
}
