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
	<h1>회원목록</h1>
	<jsp:include page="../smenu.jsp"></jsp:include>

	<form action="s_searchList.do">
		<select name="searchKey">
			<option value="id">id</option>
			<option value="name">name</option>
			<option value="lang">lang</option>
			<option value="gen">gen</option>
			<option value="home">home</option>
			<option value="career">career</option>
			
		</select> <input type="text" name="searchWord" value="ad"> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>번호</th>
				<th>ID</th>
				<th>이름</th>
				<th>성별</th>
				<th>주 언어</th>
				<th>거주지</th>
				<th>경력</th>
				<th>구직자회원/기업회원</th>
				<th>프로필사진</th>
				<th></th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="s_selectOne.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.gen}</td>
				<td>${vo.lang}</td>
				<td>${vo.gen}</td>
				<td>${vo.career}</td>
				<td>${vo.divi}</td>
				<td><img width="100" alt="" src="upload/${vo.filename}"></td>
				
				<td><a href="s_deleteOK.do?num=${vo.num}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>