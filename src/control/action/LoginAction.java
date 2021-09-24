package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.mem.MemDAO;
import model.mem.MemVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=null;
		
		// 1. mvo를 만들 수 있는 인자들을 get()
		// 2. login 성공 or 실패 여부를 판단
		// 3. 성공 : session SET / 실패 : 스크립트 출력
		
		MemVO mvo=new MemVO();
		MemDAO mdao=new MemDAO();
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		if(mdao.login(mvo)) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", mvo.getMid());
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('다시 로그인!');history.go(-1);</script>");
		}
		return forward;
	}

}
