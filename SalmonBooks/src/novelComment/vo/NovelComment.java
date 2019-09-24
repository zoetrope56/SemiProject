package novelComment.vo;

import java.io.Serializable;
import java.sql.Date;

public class NovelComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cno;
	private int nno;
	private int dno;
	private String ccontent;
	private String cwriter;
	private Date cdate;
	private int refcno;
	private int clevel;
	
	public NovelComment() {}

	public NovelComment(int cno, int nno, int dno, String ccontent, String cwriter, String cwriterId, Date cdate,
			int refcno, int clevel) {
		super();
		this.cno = cno;
		this.nno = nno;
		this.dno = dno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
	}
	

	public NovelComment(int nno, int dno, String ccontent, String cwriter, int refcno, int clevel) {
		super();
		this.nno = nno;
		this.dno = dno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.refcno = refcno;
		this.clevel = clevel;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}


	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getRefcno() {
		return refcno;
	}

	public void setRefcno(int refcno) {
		this.refcno = refcno;
	}

	public int getClevel() {
		return clevel;
	}

	public void setClevel(int clevel) {
		this.clevel = clevel;
	}

	@Override
	public String toString() {
		return "NovelComment [cno=" + cno + ", nno=" + nno + ", dno=" + dno + ", ccontent=" + ccontent + ", cwriter="
				+ cwriter +  ", cdate=" + cdate + ", refcno=" + refcno + ", clevel="
				+ clevel + "]";
	}
	
	

}
