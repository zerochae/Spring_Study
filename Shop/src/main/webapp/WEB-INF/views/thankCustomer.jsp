<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.net.URLDecoder"%>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>주문 완료</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 완료</h1>
		</div>
	</div>
	<div class="container">
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p>	주문은 ${shippingInfo.shippingDate}에 배송될 예정입니다! !	</p>
		<p>	주문번호 ${shippingInfo.shipping_cartId}		</p>
	</div>
	<div class="container">
		<p>	<a href="./products.jsp" class="btn btn-secondary"> &laquo; 상품 목록</a> </p>		
	</div>
</body>
</html>
