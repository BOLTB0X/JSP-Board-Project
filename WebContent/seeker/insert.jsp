<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
	<h1>구직자용 회원가입</h1>
	<jsp:include page="../smenu.jsp"></jsp:include>
<form action="s_idCheck.do" method="post">
		아이디 중복검사<input type="text" name="id" value="${param.id}">
		<input type="submit" value="idCheck">${param.msg}
	</form>
	<form action="s_insertOK.do" method="post" encType="multipart/form-data">
		<table border="1">
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="id" value="${param.id}"></td>
			</tr>
			
			<tr>
				<td>pw:</td>
				<td><input type="text" name="pw" value="hi123456"></td>
			</tr>
			
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" value="Lee"></td>
			</tr>
			<tr>
				<td>성별:</td>
				<td><input type="text" name="gen" value="men"></td>
			</tr>
			<tr>
				<td>주 프로그래밍 언어:</td>
				<td><input type="text" name="lang" value="java"></td>
			</tr>
			<tr>
				<td>거주지:</td>
				<td><input type="text" name="home" value="seoul"></td>
			</tr>
			<tr>
				<td>경력:</td>
				<td><input type="text" name="career" value="신입"></td>
			</tr>
			<tr>
				<td>구직자회원/기업회원:</td>
				<td><input type="text" name="divi" value="seeker"></td>
			</tr>
			<tr>
				<td>사진입력:</td>
				<td><input type="file" name="pusa"></td>
			</tr>
			<tr>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>		
	</form>
</body>
</html>