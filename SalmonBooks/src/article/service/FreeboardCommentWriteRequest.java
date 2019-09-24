package article.service;

import java.util.Map;

public class FreeboardCommentWriteRequest {
	private CommentWriter writer;
	private String content;
	private int articleNo;
	
	
	
	public FreeboardCommentWriteRequest(CommentWriter writer, String content, int articleNo) {
		super();
		this.writer = writer;
		this.content = content;
		this.articleNo = articleNo;
	}
	public CommentWriter getWriter() {
		return writer;
	}
	public String getContent() {
		return content;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void validate(Map<String, Boolean> errors) {
		if(content== null || content.trim().isEmpty()) {
			errors.put("content", Boolean.TRUE);
		}
	}
}
