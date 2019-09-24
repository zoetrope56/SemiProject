package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import article.dao.FreeboardArticleCommentDao;
import article.dao.FreeboardArticleContentDao;
import article.dao.FreeboardArticleDao;
import article.model.FreeboardArticle;
import article.model.FreeboardArticleComment;
import article.model.FreeboardArticleContent;
import article.model.FreeboardArticleData;
import jdbc.connection.ConnectionProvider;

public class FreeboardReadArticleService {
	private FreeboardArticleDao articleDao = new FreeboardArticleDao();
	private FreeboardArticleContentDao articleContentDao = new FreeboardArticleContentDao();
	private FreeboardArticleCommentDao commentDao = new FreeboardArticleCommentDao();
	public FreeboardArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try(Connection conn = ConnectionProvider.getConnection()){
			FreeboardArticle article = articleDao.selectById(conn, articleNum);
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			FreeboardArticleContent content = articleContentDao.selectById(conn, articleNum);
			if(content == null) {
				throw new ArticleContentNotFoundException();
			}
			List<FreeboardArticleComment> commentList = commentDao.selectByArticleNo(conn, articleNum);
			if(commentList == null) {
				throw new ArticleCommentNotFoundException();
			}
			if(increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			int commentCount = commentDao.selectCount(conn, articleNum);
			return new FreeboardArticleData(article, content, commentList, commentCount);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
