package article.model;

import java.util.Date;

public class FreeboardArticleComment {
	private Integer commentId;
	private Integer articleNo;
	private String writerId;
	private Date regDate;
	private Date modDate;
	private String content;
	
	
	
	public FreeboardArticleComment(Integer commentId, Integer articleNo, String writerId, Date regDate, Date modDate,
			String content) {
		super();
		this.commentId = commentId;
		this.articleNo = articleNo;
		this.writerId = writerId;
		this.regDate = regDate;
		this.modDate = modDate;
		this.content = content;
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
