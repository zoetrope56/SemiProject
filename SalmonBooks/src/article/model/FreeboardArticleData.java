package article.model;

import java.util.List;

public class FreeboardArticleData {
	private FreeboardArticle article;
	private FreeboardArticleContent content;
	private List<FreeboardArticleComment> commentList;
	private int commentCount;
	
	public FreeboardArticleData(FreeboardArticle article, FreeboardArticleContent content,
			List<FreeboardArticleComment> commentList, int commentCount) {
		super();
		this.article = article;
		this.content = content;
		this.commentList = commentList;
		this.commentCount = commentCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setArticle(FreeboardArticle article) {
		this.article = article;
	}

	public void setContent(FreeboardArticleContent content) {
		this.content = content;
	}

	public void setCommentList(List<FreeboardArticleComment> commentList) {
		this.commentList = commentList;
	}

	public FreeboardArticle getArticle() {
		return article;
	}
	public String getContent() {
		return content.getContent();
	}
	public List<FreeboardArticleComment> getCommentList() {
		return commentList;
	}
}
