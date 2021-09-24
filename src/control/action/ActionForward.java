package control.action;

public class ActionForward {
	
	// ActionForward는 페이지 전달 방식과 어디로 가는지 경로를 담은 일종의 객체
	
	private boolean redirect; // 전달 방식
	private String path; // page 경로
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
