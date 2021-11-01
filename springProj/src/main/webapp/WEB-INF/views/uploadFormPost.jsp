<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>업로드된 파일 정보 뷰</title>
</head>
<body>

	<div class="container">
		<div align="center" class="row">
			<c:forEach var="rec" items="${list}">
				<div class="col-md-4">
					<h3>${list}</h3>
					<p></p>
			</c:forEach>
		</div>
	</div>
	</div>

</body>
</html>