<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${empty seUser}">
	<div class="right2">
		<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="cnt" value="${cnt}">
			<input type="text" name="mid" placeholder="ID">
			<input type="password" name="mpw" placeholder="PW">
			<input type="submit" value="LogIn">&emsp;<button onclick="newMem()">SignUp</button>
		</form>
	</div>
	</c:when>
	<c:otherwise>
		<div class="right">
		<span class="bold">${seUser}😎</span>&emsp;
		<button onclick="location.href='control.jsp?action=main&selUser=${seUser}&cnt=${cnt}'">내 글</button>&emsp;
		<button onclick="location.href='control.jsp?action=logout'">LogOut</button>&emsp;
		<button onclick="del()">탈퇴</button>
		</div>
	</c:otherwise>
</c:choose>