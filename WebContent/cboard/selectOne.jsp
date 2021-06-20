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
	<h1>채용정보</h1>	
	<table border="1">
		<tr>
			<td>번호</td><td>${vo2.num}</td>
		</tr>
		<tr>
			<td>제목</td><td>${vo2.title}</td>
		</tr>
		<tr>
			<td>내용</td><td>${vo2.content}</td>
		</tr>
		<tr>
			<td>기업명</td><td>${vo2.writer}</td>
		</tr>
		<tr>
			<td>공고일</td><td>${vo2.str_wdate}</td>
		</tr>
		<tr>
			<td>조회수</td><td>${vo2.cnt}</td>
		</tr>
		<tr>
			<td>추천</td><td>${vo2.lik}</td>
		</tr>
	
	</table>
	<c:if test='${sessionScope.userDIVI == "company"}'>
		<a href="c_start.do">돌아가기</a><
	</c:if>
	<c:if test='${sessionScope.userDIVI == "seeker"}'>
		<a href="start.do">돌아가기</a>
	</c:if>

</body>
</html>