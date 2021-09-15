<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${empty seUser}">
	<h3>${empty seUser}</h3>
		<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="cnt" value="${cnt}">
			<input type="text" name="mid" placeholder="ID">
			<input type="password" name="mpw" placeholder="PW">
			<input type="submit" value="LogIn">
		</form>
		<button onclick="newMem()">SignUp</button>
	</c:when>
	<c:otherwise>
		<span>${seUser}😎</span>&emsp;
		<button onclick="location.href='control.jsp?action=main&selUser=${seUser}&cnt=${cnt}'">내 글</button>&emsp;
		<button onclick="location.href='control.jsp?action=logout'">LogOut</button>
		<button onclick="del()">탈퇴</button>
	</c:otherwise>
</c:choose>