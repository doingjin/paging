<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Post</title>
</head>
<body>
<h1>New Post</h1>
<hr>
	<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="newPost">
		<input type="hidden" name="mid" value="${selUser}">
		<span>content</span><br>
		<textarea rows="4" cols="40" name="content"></textarea><br>
		<input type="submit" value="작성완료!">
	</form>&emsp;
</body>
</html>