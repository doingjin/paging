<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script type="text/javascript">
	function del(){
		res=confirm('정말 탈퇴하시겠습니까?');
		if(res){
			location.href='control.jsp?action=delMem&mid=${seUser}';
		} else {
			return false;
		}
	}
	function newMem(){
		window.open("newMem.jsp","Create Account","width=600,height=500");
	}
</script>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<%-- <ol>
	<li><a href="control.jsp?action=main">전체목록보기</a></li>
	<c:if test="${empty seUser}">
	<li><a onclick="newMem()">회원가입</a></li>
	</c:if>
</ol> --%>

<a href="control.jsp?action=main" title="메인으로 이동!"><img alt="logo" src="img/signboard.png" class="logo left"></a><br>


<!-- LOGIN / LOGOUT 부분!!! -->
<mytag:login/>
<br>
<hr style="clear: both">
<!-- -------------------------- POST LIST 부분!!! -------------------------- -->
<div class="left">
	<h2>전 체 목 록</h2>
	<c:forEach var="v" items="${datas}">
		<c:set var="m" value="${v.p}"/>
		<h3>[${m.mid}😎] ${m.content} &emsp;▶&emsp;[좋아요 ${m.favcnt} | 댓글 ${m.comcnt} | ${m.pdate}]
			<c:if test="${!empty seUser}">
				<a href="control.jsp?action=addFav&pnum=${m.pnum}&cnt=${cnt}" title="좋아요🧡">🧡</a>
			</c:if>
			<mytag:delete type="post" id="${m.mid}" num="${m.pnum}"/>
		</h3>
		<ol><c:forEach  var="c" items="${v.clist}">
			<li>${c.mid}😎 ▶ ${c.comm} [${c.cdate}]
				<mytag:delete type="comm" id="${c.mid}" num="${c.cnum}"/>
			</li>
		</c:forEach>
		<c:if test="${empty v.clist}">❌작성된 댓글이 없습니다❌</c:if></ol>
		<p><mytag:new type="comm" pnum="${m.pnum}"/></p>
		
	</c:forEach><br>
	<c:if test="${empty datas}">❌아직 작성된 글이 없습니다❌<br><br></c:if>
	<%-- 개수:${PostNum} 카운트:${cnt} --%>
	<c:if test="${cnt<PostNum}">
		<a href="control.jsp?action=main&cnt=${cnt+1}&selUser=${selUser}" class="bold">⭐see more...</a>
	</c:if>
	<hr>
	<!-- NEW POST 부분!!! -->
	<mytag:new type="post"/>
	
	<hr>
	<!-- 신규 회원 목록 부분!!! -->
	<h3>신규회원 목록</h3>
		<ul>
		<c:forEach var="v" items="${newUsers}">
			<li><a href="control.jsp?action=main&cnt=${cnt}&selUser=${v.mid}">${v.name}</a>님</li>
		</c:forEach>
		</ul>
</div>
<div class="right">
<a href="https://www.google.com/" title="google" target="_blank"><img alt="google" src="img/KakaoTalk_20210818_103500868.jpg"></a><br>
<a href="https://www.youtube.com/" title="youtube" target="_blank"><img alt="youtube" src="img/KakaoTalk_20210818_103500868_02.jpg"></a><br>
<a href="https://www.naver.com/" title="naver" target="_blank"><img alt="naver" src="img/KakaoTalk_20210818_103500868_03.jpg"></a><br>
</div>
</body>
</html>