<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
	<h1>이력서검색</h1>

	<form action="sb_searchList.do">
		<select name="searchKey">
			<option value="title">title</option>
			<option value="content">content</option>
			<option value="writer">writer</option>
		</select> <input type="text" name="searchWord" value=" "> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="sb_selectOne.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.str_wdate}</td>
				<td>${vo.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test='${sessionScope.userDIVI == "company"}'>
		<a href="c_start.do">돌아가기</a>
	</c:if>
	<c:if test='${sessionScope.userDIVI == "seeker"}'>
		<a href="start.do">돌아가기</a>
	</c:if>
</body>
</html>