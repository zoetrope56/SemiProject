package novel.vo;

import java.io.Serializable;
import java.sql.Date;

public class NovelInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private int nno;		 	 // 소설 넘버
	private String genre;		 // 소설 장르
	private String ntitle;		 // 소설 제목
	private String Free;		 // 무료 여부
	private String nWriter; 	 // 작가
	private String nSimpContent; // 줄거리 요약
	private int total;			 // 편 수
	private double rate;		 // 평점
	private int nView;			 // 조회수
	private String img;			 // 이미지파일경로
	private String Complete;	 // 완결 여부
	private int pay;			 // 요금
	
	public NovelInfo() {
	}

	public NovelInfo(int nno, String genre, String ntitle, String free, String nWriter, String nSimpContent, int total,
			double rate, int nView, String img, String complete, int pay) {
		super();
		this.nno = nno;
		this.genre = genre;
		this.ntitle = ntitle;
		Free = free;
		this.nWriter = nWriter;
		this.nSimpContent = nSimpContent;
		this.total = total;
		this.rate = rate;
		this.nView = nView;
		this.img = img;
		Complete = complete;
		this.pay = pay;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getFree() {
		return Free;
	}

	public void setFree(String free) {
		Free = free;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public String getnSimpContent() {
		return nSimpContent;
	}

	public void setnSimpContent(String nSimpContent) {
		this.nSimpContent = nSimpContent;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getnView() {
		return nView;
	}

	public void setnView(int nView) {
		this.nView = nView;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getComplete() {
		return Complete;
	}

	public void setComplete(String complete) {
		Complete = complete;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "NovelInfo [nno=" + nno + ", genre=" + genre + ", ntitle=" + ntitle + ", Free=" + Free + ", nWriter="
				+ nWriter + ", nSimpContent=" + nSimpContent + ", total=" + total + ", rate=" + rate + ", nView="
				+ nView + ", img=" + img + ", Complete=" + Complete + ", pay=" + pay + "]";
	}

	
	
	
	
}
