<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Board</title>
</head>
<body>

	<h3>LIST</h3>
	
	<a href="/board/get?register">REGISTER</a>
	<a href="/board/get?update">UPDATE</a>
	<a href="/board/get?delete">DELETE</a>

	<form action="/board/get" method="get">
	
		<button type="submit" name="modify">수정</button>
		<button type="submit" name="remove">삭제</button>
		<button type="submit" name="list">목록</button>
		
	</form>

</body>
</html>