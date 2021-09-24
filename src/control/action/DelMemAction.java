package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.mem.MemDAO;
import model.mem.MemVO;

public class DelMemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward=new ActionForward();
		
		MemVO mvo=new MemVO();
		MemDAO mdao=new MemDAO();
		mvo.setMid(request.getParameter("mid"));
		
		
		if(mdao.delMem(mvo)){
			HttpSession session=request.getSession();
			session.invalidate();
			forward.setRedirect(true);
			forward.setPath("main.do");
		} else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('회원 삭제 실패!');history.go(-1);</script>");
		}
		return forward;
	}

}
