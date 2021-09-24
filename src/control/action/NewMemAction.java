package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.mem.MemDAO;
import model.mem.MemVO;

public class NewMemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=null;
		
		MemVO mvo=new MemVO();
		MemDAO mdao=new MemDAO();
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		mvo.setName(request.getParameter("name"));
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(mdao.newMem(mvo)){
			out.println("<script>alert('회원가입이 완료되었습니다!');window.close();</script>");
		} else {
			out.println("<script>alert('존재하는 아이디입니다!');history.go(-1);</script>");
		}
		
		
		return forward; // ==null
	}

}
