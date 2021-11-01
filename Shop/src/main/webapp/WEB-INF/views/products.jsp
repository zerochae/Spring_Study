<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"/>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
		</div>
	</div>
		<div class="container">
			<div class="row" align="center">
			
					<c:forEach var="row" items="${data}">
					<div class="col-md-4">
					<img alt="" src="/images/" style=" width:100%; height: 240px">
					<h3>${row.P_NAME} </h3>
					<p>${row.P_P_DESCRIPTION}</p>
					<p> ₩ ${row.P_UNITPRICE}</p>
					<p><a href="product?id=${row.P_ID}" class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
					</div>
					</c:forEach>
			</div> 
		</div>
	

	<jsp:include page="footer.jsp"/>


</body>
</html>


