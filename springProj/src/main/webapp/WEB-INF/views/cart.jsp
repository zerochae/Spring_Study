<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
</head>
<body>



	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>	
		</div>
	
		<div class="container">
			<div class="row">
				<table width="100%">
					<tr>
						<td align="left">
							<a href="/deleteCart?cartId=${session_id}" class="btn btn-danger">삭제하기</a>
						</td>
						<td align="right">
							<a href="/shippingInfo?cartId=${session_id}" class="btn btn-success">주문하기</a>
						</td>
					</tr>
				</table>
			</div>
			<div style="padding-top:50px">
				<table class="table table-hover">
					<tr>
						<td>상품</td>
						<td>가격</td>
						<td>수량</td>
						<td>소계</td>
						<td>비고</td>
					</tr>
					<c:forEach var="cart" items="${cart}" >
					
					<tr>
						<td>${cart.P_ID} - ${cart.P_NAME}</td>
						<td><fmt:formatNumber value='${cart.P_UNITPRICE}' pattern="#,###" /></td>
						<td>${cart.quantity}</td>
					<c:set var="total" value="${cart.P_UNITPRICE * cart.quantity}"> </c:set>
						<td><fmt:formatNumber value='${total}' pattern="#,###" /></td>
					<c:set var = "sum" value="${sum + total}"></c:set>
						<td><a href="/removeCart?P_ID=${cart.P_ID}" class="badge badge-danger"> 삭제 </a></td>
					
					</tr>
					
					</c:forEach>
					
					<tr>
						<td></td>
						<td></td>
						<td>총액</td>
						<td><fmt:formatNumber value='${sum}' pattern="#,###" /></td>
						<td></td>
					</tr>
				</table>
				<a href="/products" class="btn btn-secondary">쇼핑계속하기&laquo;</a>
			</div>
			<hr>
		</div>
	</div>
</body>
</html>