<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>책 목록</title>
<script type="text/javascript">
	function fn_create() {
		location.href = "/create";
	}
</script>
</head>
<body>

	<h1>책 목록</h1>

	<form>
		<!-- form 태그의 기본 HTTP 메소드는 get임 . action을 생략하면 현재 uri을 요청 -->
		<p>
			<input type="text" name="keyword" value="${keyword}" /> 
			<input type="submit" value="검색" />
		</p>
	</form>

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
	<input type="button" onclick="fn_create()" value="저장">
</body>
</html>