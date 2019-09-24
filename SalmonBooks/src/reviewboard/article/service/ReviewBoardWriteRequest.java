package reviewboard.article.service;

import java.util.Map;

import reviewboard.article.model.ReviewBoardWriter;

public class ReviewBoardWriteRequest {
	private ReviewBoardWriter writer;
	private String title;
	private String content;
	private String category;
	
	
	public ReviewBoardWriteRequest(ReviewBoardWriter writer, String title, String content, String category) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.category = category;
	}


	public ReviewBoardWriter getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getCategory() {
		return category;
	}
	public void validate(Map<String, Boolean> errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
		
	}
	
	
}
