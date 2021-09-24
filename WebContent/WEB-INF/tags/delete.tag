<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="type" %>
<%@ attribute name="id" %>
<%@ attribute name="num" %>

<c:choose>
	<c:when test="${type == 'post'}">
		<c:if test="${id == seUser}">
			<button onclick="location.href='delPost.do?pnum=${num}&cnt=${cnt}'">삭제</button>
		</c:if>
	</c:when>
	
	<c:when test="${type == 'comm'}">
		<c:if test="${id == seUser}">
			<button onclick="location.href='delComm.do?cnum=${num}&cnt=${cnt}'">댓글삭제</button>
		</c:if>
	</c:when>
</c:choose>