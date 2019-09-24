package article.service;

public class CommentWriter {
	private String id;
	private String name;
	
	public CommentWriter(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
