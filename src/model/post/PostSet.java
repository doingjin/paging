package model.post;

import java.util.ArrayList;

public class PostSet {
	
	private PostVO p;
	private ArrayList<CommVO> clist;
	
	public PostVO getP() {
		return p;
	}
	public void setP(PostVO p) {
		this.p = p;
	}
	public ArrayList<CommVO> getClist() {
		return clist;
	}
	public void setClist(ArrayList<CommVO> clist) {
		this.clist = clist;
	}
	
	@Override
	public String toString() {
		return "PostSet [p=" + p + ", clist=" + clist + "]";
	}
}
