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
	<h1>등록회사목록</h1>
	<jsp:include page="../cmenu.jsp"></jsp:include>

	<form action="c_searchList.do">
		<select name="searchKey">
			<option value="id">id</option>
			<option value="name">name</option>
			<option value="wrok">work</option>
			<option value="tel">tel</option>
			<option value="loca">loca</option>
			<option value="salary">salary</option>
		</select> <input type="text" name="searchWord" value="ad"> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>NUM</th>
				<th>기업명</th>
				<th>기업대표</th>
				<th>업무분야</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>평균연봉</th>
				<th>구직자회원/기업회원</th>
				<th>회사로고</th>
				<th></th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="c_selectOne.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.work}</td>
				<td>${vo.tel}</td>
				<td>${vo.loca}</td>
				<td>${vo.salary}</td>
				<td>${vo.divi}</td>
				<td><img width="100" alt="" src="upload/${vo.filename}"></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>