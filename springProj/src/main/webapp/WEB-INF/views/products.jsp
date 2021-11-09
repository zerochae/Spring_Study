<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>


	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
		</div>
	</div>
		<div class="container">
			<div class="row" align="center">
			
					<c:forEach var="row" items="${data}">
					<div class="col-md-4">
					<img alt="" src="/resources/images/${row.P_FILENAME}" style=" width:100%; height: 240px">
					<h3>${row.P_NAME} </h3>
					<p>${row.P_DESCRIPTION}</p>
					<p> ₩ <fmt:formatNumber value="${row.P_UNITPRICE}" pattern="#,###"/></p>
					<p><a href="product?P_ID=${row.P_ID}" class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
					</div>
					</c:forEach>
			</div> 
		</div>
	



</body>
</html>


