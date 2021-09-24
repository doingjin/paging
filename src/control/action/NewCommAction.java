package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.CommDAO;
import model.post.CommVO;

public class NewCommAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=null;
		
		CommVO cvo=new CommVO();
		cvo.setPnum(Integer.parseInt(request.getParameter("pnum")));
		cvo.setMid(request.getParameter("mid"));
		cvo.setComm(request.getParameter("comm"));
		CommDAO cdao=new CommDAO();
		
		
		if(cdao.newComm(cvo)){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		} else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('댓글쓰기 실패!');history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
