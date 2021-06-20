<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
	<h1>이력서 작성</h1>
	<jsp:include page="../smenu.jsp"></jsp:include>
	
	<form action="sb_insertOK.do" method="post">
		<table border="1">
			<tr>
				<td>제목:</td>
				<td><input type="text" name="title" value="plz"></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><textarea name="content" rows="5" cols="20" >I'm a men.</textarea></td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td><input type="text" name="writer" value="${sessionScope.userID}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
</body>
</html>