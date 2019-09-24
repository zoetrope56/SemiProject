package reviewboard.article.model;

import java.util.Date;
//세번째다 이 바보야
import article.model.FreeboardWriter;

public class ReviewBoardArticle {

	private Integer number;
	private ReviewBoardWriter writer;   //올린사람
	private String title; //제목
	private Date regDate; //올린날짜
	private Date modifiedDate; //수정날짜
	private String category; //카테고리
	private int readCount; //카운트
	private int recommend;
	
	
	public ReviewBoardArticle(Integer number, ReviewBoardWriter writer, String title, Date regDate, Date modifiedDate,
			String category, int readCount, int recommend) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.category = category;
		this.readCount = readCount;
		this.recommend = recommend;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public ReviewBoardWriter getWriter() {
		return writer;
	}


	public void setWriter(ReviewBoardWriter writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getRecommend() {
		return recommend;
	}


	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}




	








}