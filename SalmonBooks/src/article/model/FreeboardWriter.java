package article.model;

public class FreeboardWriter {
	private String id;
	private String name;
	
	public FreeboardWriter(String id, String name) {
		super();
		this.id = id;
		this.name= name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
