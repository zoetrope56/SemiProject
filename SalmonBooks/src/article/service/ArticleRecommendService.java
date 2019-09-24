package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.FreeboardArticleDao;
import jdbc.connection.ConnectionProvider;

public class ArticleRecommendService {
	private FreeboardArticleDao articleDao = new FreeboardArticleDao();
	public int increaseRecommend(int no) {
		try(Connection conn = ConnectionProvider.getConnection()){
			articleDao.increaseRecommendCount(conn, no);
			return articleDao.selectById(conn, no).getRecommend();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
