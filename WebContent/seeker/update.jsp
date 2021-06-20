<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<h1>회원정보수정</h1>
	<jsp:include page="../smenu.jsp"></jsp:include>


	<form action="s_updateOK.do" method="post">
		<table border="1">
			<tr>
				<td>글번호:</td>
				<td>${param.num}<input type="hidden" name="num" value="${param.num}"></td>
			</tr>
			<tr>
				<td>아이디:</td>
				<td>${param.id}<input type="hidden" name="id" value="${param.id}"></td>
			</tr>
			
			<tr>
				<td>pw:</td>
				<td><input type="text" name="pw" value="hi123456"></td>
			</tr>
			
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" value="홍길동"></td>
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
				<td><input type="text" name="career" value="${param.career}"></td>
			</tr>
			<tr>
				<td>구직자회원/기업회원:</td>
				<td><input type="text" name="divi" value="seeker"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
</body>
</html>