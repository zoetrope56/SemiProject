package article.model;

public class FreeboardArticleContent {
	private Integer number;
	private String content;
	
	
	
	public FreeboardArticleContent(Integer number, String content) {
		super();
		this.number = number;
		this.content = content;
	}
	
	public Integer getNumber() {
		return number;
	}
	public String getContent() {
		return content;
	}
	
	
}
