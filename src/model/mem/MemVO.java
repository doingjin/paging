package model.mem;

public class MemVO {
	private String mid;
	private String name;
	private String mpw;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	@Override
	public String toString() {
		return "MemVO [mid=" + mid + ", name=" + name + ", mpw=" + mpw + "]";
	}  
}
