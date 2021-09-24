package control.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.action.ActionForward;
import control.action.AddFavAction;
import control.action.DelCommAction;
import control.action.DelMemAction;
import control.action.DelPostAction;
import control.action.LoginAction;
import control.action.LogoutAction;
import control.action.MainAction;
import control.action.NewCommAction;
import control.action.NewMemAction;
import control.action.NewPostAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 사용자의 요청을 분석
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
		
		ActionForward forward=null;
		
		// 2) controller와 MAPPING
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/newMem.do")) {
			forward=new NewMemAction().execute(request, response);
			// == null
		}
		else if(action.equals("/newPost.do")) {
			forward=new NewPostAction().execute(request, response);
		}
		else if(action.equals("/newComm.do")) {
			forward=new NewCommAction().execute(request, response);
		}
		else if(action.equals("/delPost.do")) {
			forward=new DelPostAction().execute(request, response);
		}
		else if(action.equals("/delComm.do")) {
			forward=new DelCommAction().execute(request, response);
		}
		else if(action.equals("/delMem.do")) {
			forward=new DelMemAction().execute(request, response);
		}
		else if(action.equals("/addFav.do")) {
			forward=new AddFavAction().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
			// forward가 null로 초기화되어있기 때문에 새로 만들어서 에러페이지로 이동
		}
		
		if(forward!=null) { // 🌟🌟 null이 아닌 경우에만 실행
			// 3) 사용자에게 결과화면 전달!
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} // -> 전달해줘야 할 request 같은 것이 없으면 Redirect로 전달 가능해서 바로 전달!
				// 요청 헤더가 바껴버림
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			} // -> 전달해줘야 할 request 같은 인자가 있기 때문에 얘네 붙여서 같이 전달하려고 dispatcher 필요!
		}
	}
}
