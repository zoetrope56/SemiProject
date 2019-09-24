package reviewboard.article.service;

import java.util.List;

import reviewboard.article.model.ReviewBoardArticleComment;


public class ReviewBoardCommentPage {
	List<ReviewBoardArticleComment> list;
	int commentCount;
	
	public ReviewBoardCommentPage(List<ReviewBoardArticleComment>list, int commentCount) {
		super();
		this.list=list;
		this.commentCount=commentCount;
	}

	public List<ReviewBoardArticleComment> getList() {
		return list;
	}

	public void setList(List<ReviewBoardArticleComment> list) {
		this.list = list;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
