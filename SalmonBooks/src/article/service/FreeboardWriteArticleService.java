package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.dao.FreeboardArticleContentDao;
import article.dao.FreeboardArticleDao;
import article.model.FreeboardArticle;
import article.model.FreeboardArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class FreeboardWriteArticleService {
	private FreeboardArticleDao articleDao = new FreeboardArticleDao();
	private FreeboardArticleContentDao articleContentDao = new FreeboardArticleContentDao();
	public Integer write(FreeboardWriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			FreeboardArticle article = toArticle(req);
			FreeboardArticle saveArticle = articleDao.insert(conn, article);
			if(saveArticle == null) {				
				throw new RuntimeException("fail to insert article_content");
			}
			
			FreeboardArticleContent content = new FreeboardArticleContent(
					saveArticle.getNumber(), req.getContent()
					);
			FreeboardArticleContent savedContent = articleContentDao.insert(conn, content);
			
			if(savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}
			conn.commit();
			return saveArticle.getNumber();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	private FreeboardArticle toArticle(FreeboardWriteRequest req) {
		Date now = new Date();
		return new FreeboardArticle(null, req.getWriter(), req.getTitle(), now, now, req.getCategory(), 0, 0);
	}
}
