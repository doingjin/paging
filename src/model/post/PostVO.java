package model.post;

import java.sql.Date;

public class PostVO {
	
	private int pnum;
	private String mid;
	private String content;
	private int favcnt;
	private int comcnt;
	private Date pdate;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getMid() {
		return mid;
	}
	
	public int getFavcnt() {
		return favcnt;
	}
	public void setFavcnt(int favcnt) {
		this.favcnt = favcnt;
	}
	public int getComcnt() {
		return comcnt;
	}
	public void setComcnt(int comcnt) {
		this.comcnt = comcnt;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "PostVO [pnum=" + pnum + ", mid=" + mid + ", content=" + content + ", favcnt=" + favcnt + ", comcnt="
				+ comcnt + ", pdate=" + pdate + "]";
	}
	
	
}
