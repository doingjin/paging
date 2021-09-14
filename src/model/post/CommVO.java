package model.post;

import java.sql.Date;

public class CommVO {
	
	private int cnum;
	private int pnum;
	private String mid;
	private String comm;
	private Date cdate;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
	@Override
	public String toString() {
		return "CommVO [cnum=" + cnum + ", pnum=" + pnum + ", mid=" + mid + ", comm=" + comm + ", cdate=" + cdate
				+ "]";
	}
	
}
