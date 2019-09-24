package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleContentDao;
import reviewboard.article.dao.ReviewBoardArticleDao;
import reviewboard.article.model.ReviewBoardArticle;
import reviewboard.article.model.ReviewBoardArticleContent;

public class ReviewBoardWriteArticleService {
	//예지는 바보다
	//홍은영도 바보다

	private ReviewBoardArticleDao articleDao = new ReviewBoardArticleDao();

	private ReviewBoardArticleContentDao articleContentDao = new ReviewBoardArticleContentDao();

	public Integer write(ReviewBoardWriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			ReviewBoardArticle article = toArticle(req);
			ReviewBoardArticle saveArticle = articleDao.insert(conn, article);

			if(saveArticle == null) {
				throw new RuntimeException("fail to insert article_content");
			}
			ReviewBoardArticleContent content = new ReviewBoardArticleContent(
					saveArticle.getNumber(), req.getContent	()
					);
			ReviewBoardArticleContent savedContent = articleContentDao.insert(conn,content);
			

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
			//즐
		}finally {
			JdbcUtil.close(conn);			
		}

	}
	private ReviewBoardArticle toArticle(ReviewBoardWriteRequest req) {
		Date now =new Date();
		return new ReviewBoardArticle(null, req.getWriter(), req.getTitle(),now,now,req.getCategory(),0,0);

	} 
}