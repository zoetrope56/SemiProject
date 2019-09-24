package reviewboard.article.model;

import java.util.List;

import reviewboard.article.dao.ReviewBoardArticleCommentDao;
import reviewboard.article.dao.ReviewBoardArticleContentDao;

public class ReviewBoardArticleData {
	private ReviewBoardArticle article;
	private ReviewBoardArticleContent content;
	private List<ReviewBoardArticleComment> commentList;
	private int commentCount;

	public ReviewBoardArticleData(ReviewBoardArticle article, ReviewBoardArticleContent content, 
			List<ReviewBoardArticleComment> commentList, int commentCount){
		super();
		this.article = article;
		this.content = content;
		this.commentList = commentList;
		this.commentCount = commentCount;
	}

	////
	public ReviewBoardArticleData(ReviewBoardArticle article, ReviewBoardArticleContent content,
			List<ReviewBoardArticleComment> commentList) {
		super();
		this.article = article;
		this.content = content;
		this.commentList = commentList;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}


	public ReviewBoardArticle getArticle() {
		return article;
	}


	public void setArticle(ReviewBoardArticle article) {
		this.article = article;
	}


	public String getContent() {
		return content.getContent();
	}


	public void setContent(ReviewBoardArticleContent content) {
		this.content = content;
	}


	public List<ReviewBoardArticleComment> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<ReviewBoardArticleComment> commentList) {
		this.commentList = commentList;
	}





}


