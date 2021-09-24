package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.CommDAO;
import model.post.CommVO;

public class DelCommAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward=new ActionForward();
		
		CommVO cvo=new CommVO();
		cvo.setCnum(Integer.parseInt(request.getParameter("cnum")));
		CommDAO cdao=new CommDAO();
		
		
		if(cdao.delComm(cvo)){
			forward.setRedirect(false);
			forward.setPath("main.do");
		} else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('댓글 삭제 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
