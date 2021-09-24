package control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.PostDAO;
import model.post.PostVO;

public class AddFavAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		PostVO pvo=new PostVO();
		pvo.setPnum(Integer.parseInt(request.getParameter("pnum")));
		PostDAO pdao=new PostDAO();
		
		
		if(pdao.addFav(pvo)){
			forward.setRedirect(false);
			forward.setPath("main.do");
		} else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('좋아요 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
