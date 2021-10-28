<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>책 목록</title>
</head>
<body>

	<h1>책 목록</h1>

	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>카테고리</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td>${row.TITLE}</td>
					<td>${row.CATEGORY}</td>
					<td>${row.PRICE}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>