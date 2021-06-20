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

	<jsp:include page="../cmenu.jsp"></jsp:include>
	<img width="100" alt="" src="upload/${sessionScope.filename}">

	<table border="1">
		<tr>
			<td>번호</td>
			<td>${vo2.num}</td>
		</tr>
		<tr>
			<td>기업명</td>
			<td>${vo2.id}</td>
		</tr>
		<tr>
			<td>기업대표</td>
			<td>${vo2.name}</td>
		</tr>
		<tr>
			<td>업무</td>
			<td>${vo2.work}</td>
		</tr>
		<tr>
			<td>회사번호</td>
			<td>${vo2.tel}</td>
		</tr>
		<tr>
			<td>근무지역</td>
			<td>${vo2.loca}</td>
		</tr>
		<tr>
			<td>평균연봉</td>
			<td>${vo2.salary}</td>
		</tr>
			<c:if test='${sessionScope.userID == vo2.id}'>
		<tr>
			<td></td>
			<td><a href="c_update.do?num=${vo2.num}">정보수정</a></td>
		</tr>
		<tr>
			<td></td>
			<td><a href="c_deleteOK.do?num=${vo2.num}">탈퇴</a></td>
		</tr>
			</c:if>
	</table>
	<a href="c_start.do">돌아가기</a>
	
</body>
</html>