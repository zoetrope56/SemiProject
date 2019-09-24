package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleDao;
import reviewboard.article.model.ReviewBoardArticle;

public class ReviewBoardListArticleService {
	private ReviewBoardArticleDao articleDao = new ReviewBoardArticleDao();
	private int size = 10;
	
	public ReviewBoardArticlePage getArticlePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(conn);
			System.out.println("pageNum" + pageNum);
			List<ReviewBoardArticle> content = articleDao.select(conn,(pageNum -1) * size, size*pageNum);
			return new ReviewBoardArticlePage(total, pageNum, size, content);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
