<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
</head>
<body>
	<h1>회원정보</h1>

	<jsp:include page="../smenu.jsp"></jsp:include>
	<img width="100" alt="" src="upload/${sessionScope.filename}">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${vo2.num}</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${vo2.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${vo2.name}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${vo2.gen}</td>
		</tr>
		<tr>
			<td>주 언어</td>
			<td>${vo2.lang}</td>
		</tr>
		<tr>
			<td>거주지</td>
			<td>${vo2.home}</td>
		</tr>
		<tr>
			<td>경력</td>
			<td>${vo2.career}</td>
		</tr>
			<c:if test='${sessionScope.userID == vo2.id}'>
		<tr>
			<td></td>
			<td><a href="s_update.do?num=${vo2.num}">정보수정</a></td>
		</tr>
		<tr>
			<td></td>
			<td><a href="s_deleteOK.do?num=${vo2.num}">탈퇴</a></td>
		</tr>
			</c:if>
	</table>
	<a href="start.do">돌아가기</a>
	
</body>
</html>