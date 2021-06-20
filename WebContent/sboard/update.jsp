<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<h1>이력서수정</h1>
	<jsp:include page="../smenu.jsp"></jsp:include>


	<form action="sb_updateOK.do" method="post">
		<table border="1">
			<tr>
				<td>글번호:</td>
				<td>${param.num}<input type="hidden" name="num" value="${param.num}"></td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="title" value="${vo2.title}"></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><textarea name="content" rows="5" cols="20">${vo2.content}</textarea></td>
			</tr>
			<tr>
				<td>작성자 ID:</td>
				<td><input type="text" name="writer" value="${vo2.writer}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
	<c:if test='${sessionScope.userDIVI == "company"}'>
		<a href="c_start.do">돌아가기</a>
	</c:if>
	<c:if test='${sessionScope.userDIVI == "seeker"}'>
		<a href="start.do">돌아가기</a>
	</c:if>
</body>
</html>