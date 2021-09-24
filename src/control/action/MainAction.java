package control.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.mem.MemDAO;
import model.mem.MemVO;
import model.post.PostDAO;
import model.post.PostSet;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		// 페이징 개수
		String cntt=request.getParameter("cnt");
		int cnt=1; // cnt가 null이거나 ""일 때 1로 지정
		if(cntt!=null) { // cnt 요청 파라미터가 있을 땐 그걸로!
			cnt=Integer.parseInt(cntt);
		}
		// 볼 유저
		String selUser=request.getParameter("selUser"); // 값이 null일 수도 있음
		
		PostDAO pdao=new PostDAO();
		MemDAO mdao=new MemDAO();
		ArrayList<PostSet> datas=pdao.selectAll(selUser, cnt); // 게시글 목록
		ArrayList<MemVO> newUsers=mdao.selectAll(); // 신규회원 목록
		int PostNum=pdao.getPostnum(selUser); // 전체 또는 특정회원 게시글 개수
		
		request.setAttribute("datas", datas); // 게시글&댓글 묶음
		request.setAttribute("newUsers", newUsers); // 신규회원 목록
		request.setAttribute("selUser", selUser); // 선택된 회원
		request.setAttribute("cnt", cnt); // 게시글 몇개 볼지
		request.setAttribute("PostNum", PostNum); // 총 게시글 개수
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}
	
}
