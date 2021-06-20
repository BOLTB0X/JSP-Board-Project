<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<h1>기업정보수정</h1>
	<jsp:include page="../cmenu.jsp"></jsp:include>


	<form action="c_updateOK.do" method="post">
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
				<td>비번:</td>
				<td><input type="text" name="pw" value="hi123456"></td>
			</tr>
			
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" value="홍길동"></td>
			</tr>
			<tr>
				<td>업무분야:</td>
				<td><input type="text" name="work" value="webpage"></td>
			</tr>
			
			<tr>
				<td>회사번호:</td>
				<td><input type="text" name="tel" value="02"></td>
			</tr>
			<tr>
				<td>지역:</td>
				<td><input type="text" name="loca" value="서울특별시 금천구"></td>
			</tr>
			<tr>
				<td> 평균연봉:</td>
				<td><input type="text" name="salary" value="2000~2500"></td>
			</tr>
			<tr>
				<td>구직자회원/기업회원:</td>
				<td><input type="text" name="divi" value="company"></td>
			</tr>
			<tr>
				<td>수정</td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
</body>
</html>