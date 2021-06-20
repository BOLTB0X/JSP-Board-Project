<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>company 회원가입</title>
</head>
<body>
	<h1>기업용 회원가입</h1>
	<jsp:include page="../cmenu.jsp"></jsp:include>
<form action="c_idCheck.do" method="post">
		아이디 중복검사<input type="text" name="id" value="${param.id}">
		<input type="submit" value="idCheck">${param.msg}
	</form>
	<form action="c_insertOK.do" method="post" encType="multipart/form-data">
		<table border="1">
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="id" value="${param.id}"></td>
			</tr>
			
			<tr>
				<td>비번:</td>
				<td><input type="text" name="pw" value="hi123456"></td>
			</tr>
			
			<tr>
				<td>대표자:</td>
				<td><input type="text" name="name" value="홍길동"></td>
			</tr>
			<tr>
				<td>업무분야:</td>
				<td><input type="text" name="work" value="webpage"></td>
			</tr>
			
			<tr>
				<td>폰번:</td>
				<td><input type="text" name="tel" value="02"></td>
			</tr>
			<tr>
				<td>지역:</td>
				<td><input type="text" name="loca" value="서울특별시 금천구"></td>
			</tr>
			<tr>
				<td>연봉:</td>
				<td><input type="text" name="salary" value="2000~2500"></td>
			</tr>
			<tr>
				<td>구직자회원/기업회원:</td>
				<td><input type="text" name="divi" value="company"></td>
			</tr>
			<tr>
				<td>사진입력:</td>
				<td><input type="file" name="pusa"></td>
			</tr>
			<tr>
				<td>제출</td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
</body>
</html>