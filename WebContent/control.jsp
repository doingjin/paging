<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.post.*,model.mem.*"%>

<jsp:useBean id="mdao" class="model.mem.MemDAO" />
<jsp:useBean id="mvo" class="model.mem.MemVO" />
<jsp:useBean id="pdao" class="model.post.PostDAO" />
<jsp:useBean id="pvo" class="model.post.PostVO" />
<jsp:useBean id="cdao" class="model.post.CommDAO" />
<jsp:useBean id="cvo" class="model.post.CommVO" />
<jsp:setProperty property="*" name="pvo" />
<jsp:setProperty property="*" name="cvo" />
<jsp:setProperty property="*" name="mvo" />

<%
	String action = request.getParameter("action");
	String url = "control.jsp?action=main";
	String cntt = request.getParameter("cnt");
	// System.out.println(cntt+" 1st cntt");
	int cnt = 1; // 받아온 cnt 파라미터 값이 없으면 cnt는 1로 지정
	if (cntt != null) {
		cnt = Integer.parseInt(cntt);
		// System.out.println(cnt+" cnt");
	}
	url = url + "&cnt=" + cnt;
	String selUser = request.getParameter("selUser");
	if (selUser != null) {
		url = url + "&selUser=" + selUser;
	}

	if (action.equals("main")) {
		ArrayList<PostSet> datas = pdao.selectAll(selUser, cnt);
		ArrayList<MemVO> newUsers = mdao.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers); // ?
		request.setAttribute("selUser", selUser);
		request.setAttribute("cnt", cnt);

		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		if(mdao.login(mvo)){
			session.setAttribute("seUser", mvo.getMid());
			// System.out.println(cnt+" login에서 cnt");
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('다시 로그인!');history.go(-1);</script>");
		}
	} else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	} else if(action.equals("newMem")){
		if(mdao.newMem(mvo)){
			response.sendRedirect("control.jsp?action=main");
		} else {
			out.println("<script>alert('존재하는 아이디입니다!');history.go(-1);</script>");
		}
	} else if(action.equals("newPost")){
		if(pdao.newPost(pvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('글쓰기 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("delPost")){
		if(pdao.delPost(pvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('삭제 실패!');history.go(-1);</script>");
		}
	}
%>