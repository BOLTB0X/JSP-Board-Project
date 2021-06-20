<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구직자회원</title>
</head>
<body>
	<h1>구직자회원 로그인</h1>
	<h1>${sessionScope.login}</h1>
	<c:if test='${sessionScope.login != "successed"}'>
	<form action="s_loginOK.do" method="post">
		<table border="1">
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="id" value="${sessionScope.userID}"></td>
			</tr>
			
			<tr>
				<td>비번:</td>
				<td><input type="password" name="pw" value="hi123456"></td>
			</tr>
			
			<tr>
				<td>제출</td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
		<h1>회원이 아니시라면 =><a href="s_insert.do">회원가입</a></h1>	
		<h1>되돌아가기 =><a href="index.do">첫 페이지</a></h1>	
	</form>
	</c:if>
	<c:if test='${sessionScope.login == "successed"}'>
		<img width="100" alt="" src="upload/${sessionScope.filename}">
		<h1>${sessionScope.userID}님 어서오세요</h1>
		<jsp:include page="../smenu.jsp"></jsp:include>
		<a href="s_logout.do">logout</a>	
	</c:if>
	
</body>
</html>