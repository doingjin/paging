<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<script type="text/javascript">

</script>
</head>
<body>
<h1>Create account</h1>
<hr>
	<form method="post" action="control.jsp">
	<input type="hidden" name="action" value="newMem">
		<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="mid"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="mpw"></td>
		</tr>
		<tr>
		<td colspan="2" align="right"><input type="submit" value="SignUp"></td>
		</tr>
		</table>
	</form>&emsp;
</body>
</html>