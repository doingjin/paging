<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="type" %>
<!-- 댓글 작성인지, 글 작성인지 나누는 타입 -->
<%@ attribute name="pnum" %>
<!-- 댓글 작성 시, form에서 받아와야 할 cnt & 글번호 -->

<c:choose>
	<c:when test="${type == 'comm'}">
		<c:if test="${!empty seUser}">
				<form method="post" action="control.jsp">
					<input type="hidden" name="action" value="newComm">
					<input type="hidden" name="cnt" value="${cnt}">
					<input type="hidden" name="mid" value="${seUser}">
					<input type="hidden" name="pnum" value="${pnum}">
					<input type="text" name="comm" size="30" placeholder="댓글을 입력해보세요!">
					<input type="submit" value="입력">
				</form>&emsp;
		</c:if>
	</c:when>
	
	<c:when test="${type == 'post'}">
		<c:choose>
			<c:when test="${empty seUser}">
				<p style="font-style:italic">❗ 글쓰기는 로그인 후 이용 가능합니다 ❗ </p>
			</c:when>
			<c:otherwise>
				<form method="post" action="control.jsp">
					<input type="hidden" name="action" value="newPost">
					<input type="hidden" name="cnt" value="${cnt}">
					<input type="hidden" name="mid" value="${seUser}">
					<span>🔽글 작성하기🔽</span><br>
					<textarea rows="4" cols="40" name="content"></textarea><br>
					<input type="submit" value="작성완료!">
				</form>&emsp;
			</c:otherwise>
		</c:choose>
	</c:when>
</c:choose>