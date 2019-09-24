package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleCommentDao;
import reviewboard.article.model.ReviewBoardArticleComment;

public class ReviewBoardListCommentService {
	private ReviewBoardArticleCommentDao commentDao = new ReviewBoardArticleCommentDao();

	public ReviewBoardCommentPage getCommentPage(int commentCount, int no) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int nowCount = commentDao.selectCount(conn,no);
			List<ReviewBoardArticleComment> list = commentDao.select(conn,no,commentCount,nowCount);
			return new ReviewBoardCommentPage(list, nowCount);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
