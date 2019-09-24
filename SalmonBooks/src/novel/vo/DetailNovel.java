package novel.vo;

import java.io.Serializable;
import java.sql.Date;

public class DetailNovel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int nno;
	private int dno;
	private String nTitle;
	private String img;
	private String dTitle;
	private Date nDate;
	private double rate;
	private String content;
	
	public DetailNovel() {
	}

	public DetailNovel(int nno, int dno, String nTitle, String img, String dTitle, Date nDate, double rate,
			String content) {
		super();
		this.nno = nno;
		this.dno = dno;
		this.nTitle = nTitle;
		this.img = img;
		this.dTitle = dTitle;
		this.nDate = nDate;
		this.rate = rate;
		this.content = content;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getdTitle() {
		return dTitle;
	}

	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DetailNovel [nno=" + nno + ", dno=" + dno + ", nTitle=" + nTitle + ", img=" + img + ", dTitle=" + dTitle
				+ ", nDate=" + nDate + ", rate=" + rate + ", content=" + content + "]";
	}
	
	
	
}