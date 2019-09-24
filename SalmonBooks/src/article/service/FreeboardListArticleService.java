package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.FreeboardArticleDao;
import article.model.FreeboardArticle;
import jdbc.connection.ConnectionProvider;

public class FreeboardListArticleService {
	private FreeboardArticleDao articleDao = new FreeboardArticleDao();
	private int size= 10;
	
	public FreeboardArticlePage getArticlePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(conn);
			List<FreeboardArticle> cotnent = articleDao.select(conn, (pageNum -1) * size, size*pageNum);
			return new FreeboardArticlePage(total, pageNum, size, cotnent);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
