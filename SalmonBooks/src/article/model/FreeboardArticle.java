package article.model;

import java.util.Date;

public class FreeboardArticle {
	private Integer number;
	private FreeboardWriter writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private String category;	
	private int readCount;	
	private int recommend;
	
	public FreeboardArticle(Integer number, FreeboardWriter writer, String title, Date regDate, Date modifiedDate,
			String category, int readCount, int recommend) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
		this.category = category;
		this.recommend = recommend;
	}
	
	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setWriter(FreeboardWriter writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getNumber() {
		return number;
	}
	public FreeboardWriter getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
}
