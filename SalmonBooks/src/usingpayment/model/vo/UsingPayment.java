package usingpayment.model.vo;

import java.sql.Date;

public class UsingPayment {
	
	private int nno;
	private int dno;
	private String title;
	private Date uDate;
	private int pay;
	private String userId;
	
	
	public UsingPayment() {}


	public UsingPayment(int nno, int dno, String title, Date uDate, int pay, String userId) {
		super();
		this.nno = nno;
		this.dno = dno;
		this.title = title;
		this.uDate = uDate;
		this.pay = pay;
		this.userId = userId;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getuDate() {
		return uDate;
	}


	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}


	public int getPay() {
		return pay;
	}


	public void setPay(int pay) {
		this.pay = pay;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "UsingPayment [nno=" + nno + ", dno=" + dno + ", title=" + title + ", uDate=" + uDate + ", pay=" + pay
				+ ", userId=" + userId + "]";
	}


	
	

}
