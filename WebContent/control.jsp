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
		int PostNum=pdao.getPostnum(selUser); // 전체 또는 특정회원 게시글 개수
		
		request.setAttribute("datas", datas); // 게시글&댓글 묶음
		request.setAttribute("newUsers", newUsers); // 신규회원 목록
		request.setAttribute("selUser", selUser); // 선택된 회원
		request.setAttribute("cnt", cnt); // 게시글 몇개 볼지
		request.setAttribute("PostNum", PostNum); // 총 게시글 개수
		
		
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
			out.println("<script>alert('회원가입이 완료되었습니다!');window.close();</script>");
			//response.sendRedirect("control.jsp?action=main");
		} else {
			out.println("<script>alert('존재하는 아이디입니다!');history.go(-1);</script>");
		}
	} else if(action.equals("newPost")){
		if(pdao.newPost(pvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('글쓰기 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("newComm")){
		if(cdao.newComm(cvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('댓글쓰기 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("delPost")){
		if(pdao.delPost(pvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('글 삭제 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("delComm")){
		if(cdao.delComm(cvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('댓글 삭제 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("delMem")){
		if(mdao.delMem(mvo)){
			session.invalidate();
			response.sendRedirect("control.jsp?action=main");
		} else {
			out.println("<script>alert('회원 삭제 실패!');history.go(-1);</script>");
		}
	} else if(action.equals("addFav")){
		if(pdao.addFav(pvo)){
			response.sendRedirect(url);
		} else {
			out.println("<script>alert('좋아요 실패!');history.go(-1);</script>");
		}
	}
%>