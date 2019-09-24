package payment.model.vo;

import java.sql.Date;

public class Payment {
	
	private int pno;
	private Date pDate;
	private String userId;
	private int point;
	private String status;
	private int userPoint;
	
	
	public Payment() {}


	public Payment(int pno, Date pDate, String userId, int point, String status, int userPoint) {
		super();
		this.pno = pno;
		this.pDate = pDate;
		this.userId = userId;
		this.point = point;
		this.status = status;
		this.userPoint = userPoint;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public Date getpDate() {
		return pDate;
	}


	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getUserPoint() {
		return userPoint;
	}


	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}


	@Override
	public String toString() {
		return "Payment [pno=" + pno + ", pDate=" + pDate + ", userId=" + userId + ", point=" + point + ", status="
				+ status + ", userPoint=" + userPoint + "]";
	}
	
	
	
}