package article.service;

import java.util.List;

import article.model.FreeboardArticleComment;

public class FreeboardCommentPage {
	List<FreeboardArticleComment> list;
	int commentCount;
	
	public FreeboardCommentPage(List<FreeboardArticleComment> list, int commentCount) {
		super();
		this.list = list;
		this.commentCount = commentCount;
	}
	public List<FreeboardArticleComment> getList() {
		return list;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setList(List<FreeboardArticleComment> list) {
		this.list = list;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
