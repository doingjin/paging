<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<style type="text/css">
#box{
	display:block;
	width:400px;
	border:1px solid #FFD064;
}
</style>
</head>
<body>
<div align="center">
<h1>😎Create account😎</h1>
<div id="box"><br>
	<form method="post" action="newMem.do">
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
	</form><br>
	</div>
</div>
</body>
</html>