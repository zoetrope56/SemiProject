package reviewboard.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import article.service.ArticleCommentNotFoundException;
import article.service.ArticleContentNotFoundException;
import article.service.ArticleNotFoundException;
import jdbc.connection.ConnectionProvider;
import reviewboard.article.dao.ReviewBoardArticleCommentDao;
import reviewboard.article.dao.ReviewBoardArticleContentDao;
import reviewboard.article.dao.ReviewBoardArticleDao;
import reviewboard.article.model.ReviewBoardArticle;
import reviewboard.article.model.ReviewBoardArticleComment;
import reviewboard.article.model.ReviewBoardArticleContent;
import reviewboard.article.model.ReviewBoardArticleData;

public class ReviewBoardReadArticleService {
	private ReviewBoardArticleDao articleDao = new ReviewBoardArticleDao();
	
	private ReviewBoardArticleContentDao articleContentDao = new ReviewBoardArticleContentDao();
	
	private ReviewBoardArticleCommentDao commentDao = new ReviewBoardArticleCommentDao();
	
	public ReviewBoardArticleData getArticle(int articleNum, boolean increaseRedCount) {
		
		
		try(Connection conn = ConnectionProvider.getConnection()){
			ReviewBoardArticle article = articleDao.selectById(conn, articleNum);
			if(article == null ) {
				throw new ArticleNotFoundException();	
			}
			ReviewBoardArticleContent content =articleContentDao.selectById(conn, articleNum);
			if(content ==null) {
				throw new ArticleContentNotFoundException();			
			}
			
			List<ReviewBoardArticleComment> commentList = commentDao.selectByArticleNo(conn, articleNum);
			if(commentList == null) {
				throw new ArticleCommentNotFoundException();
			}
			if(increaseRedCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			int commentCount = commentDao.selectCount(conn, articleNum);
			return new ReviewBoardArticleData(article, content, commentList, commentCount);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
