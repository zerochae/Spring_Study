<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
<c:forEach var="article" items="${articlePage.content}" varStatus="stat">
		<tr>
			<td>${stat.count}</td>
			<td>${article.title}</td>
			<td>${article.writerVO.writerName}</td>
			<td>${article.readCnt}</td>
		</tr>
</c:forEach>		
	</table>

</body>
</html>