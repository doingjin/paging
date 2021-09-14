<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script type="text/javascript">
	function del(){
		res=confirm('정말 삭제하시겠습니까?');
		if(res){
			location.href='control.jsp?action=delPost&pnum=${m.pnum}';
		} else {
			return false;
		}
	}
</script>
</head>
<body>

<ol>
	<li><a href="control.jsp?action=main">전체목록보기</a></li>
	<li><a href="newMem.jsp">회원가입</a></li>
</ol>

<!-- -------------------------- POST LIST 부분!!! -------------------------- -->
<hr>
<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.p}"/>
	<h3>[${m.mid}😎] ${m.content} &emsp;▶&emsp;[좋아요 ${m.favcnt} | 댓글 ${m.comcnt} | ${m.pdate}]
	<c:if test="${m.mid == seUser}">
	<button onclick="location.href='control.jsp?action=delPost&pnum=${m.pnum}&cnt=${cnt}'">삭제</button>
	</c:if></h3>
	<ol><c:forEach  var="c" items="${v.clist}">
		<li>${c.mid}😎 ▶ ${c.comm} [${c.cdate}]</li>
	</c:forEach></ol>
</c:forEach>
<a href="control.jsp?action=main&cnt=${cnt+1}&selUser=${selUser}">load more...</a>

<hr>
<!-- -------------------------- NEW POST 부분!!! -------------------------- -->
<c:choose>
	<c:when test="${empty seUser}">
		<p>❗ 글쓰기는 로그인 후 이용 가능합니다 ❗ </p>
	</c:when>
	<c:otherwise>
		<form method="post" action="control.jsp">
			<input type="hidden" name="action" value="newPost">
			<input type="hidden" name="cnt" value="${cnt}">
			<input type="hidden" name="mid" value="${seUser}">
			<span>content</span><br>
			<textarea rows="4" cols="40" name="content"></textarea><br>
			<input type="submit" value="작성완료!">
		</form>&emsp;
	</c:otherwise>
</c:choose>

<hr>
<!-- -------------------------- LOGIN / LOGOUT 부분!!! -------------------------- -->
<c:choose>
	<c:when test="${empty seUser}">
		<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="cnt" value="${cnt}">
			<input type="text" name="mid" placeholder="ID">
			<input type="password" name="mpw" placeholder="PW">
			<input type="submit" value="LogIn">
		</form>
		<button onclick="location.href='newMem.jsp'">SignUp</button>
	</c:when>
	<c:otherwise>
		<span>${seUser}😎</span>&emsp;
		<button onclick="location.href='control.jsp?action=main&selUser=${seUser}'">내 글</button>&emsp;
		<button onclick="location.href='control.jsp?action=logout'">LogOut</button>
	</c:otherwise>
</c:choose>


</body>
</html>