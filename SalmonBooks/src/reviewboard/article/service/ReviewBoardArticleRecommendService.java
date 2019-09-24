package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleDao;

public class ReviewBoardArticleRecommendService {
	private ReviewBoardArticleDao articleDao = new ReviewBoardArticleDao();
	public int increaseRecommend(int no) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			System.out.println("으악");
		articleDao.increaseRecommendCount(conn, no);	
		return articleDao.selectById(conn, no).getRecommend();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
