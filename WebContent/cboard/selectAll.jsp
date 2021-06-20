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
	<h1>채용공고목록</h1>

	<form action="cb_searchList.do">
		<select name="searchKey">
			<option value="title">title</option>
			<option value="content">content</option>
			<option value="writer">writer</option>
		</select> 
		<input type="text" name="searchWord" value="">
		<input type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>기업명</th>
				<th>공고일</th>
				<th>조회수</th>
				<th>추천</th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="cb_selectOne.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.str_wdate}</td>
				<td>${vo.cnt}</td>
				<td>${vo.lik}</td>
				<c:if test='${sessionScope.userDIVI == "seeker"}'>
					<td><a href="cb_likeupOK.do?num=${vo.num}">likeup</a></td>
				</c:if>
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