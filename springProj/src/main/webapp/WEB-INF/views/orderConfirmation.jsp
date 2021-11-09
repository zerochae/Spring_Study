<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>orderConfirmation</title>
</head>
<body>


	
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"> 주문 정보 </h1>
		</div>
	</div>
	
	<div class="container col-8 alert alert-info">
		<div class="text-center">
			<h1>영수증</h1>
		</div>
		 <div class="row jusity-content-between">
		 	<div class="col-4" align="left">
		 		<strong>배송 주소</strong>
		 		<br>
		 		<p>성명  ${shippingInfo.shipping_name}</p>
		 		<p>우편번호  ${shippingInfo.shipping_zipCode}</p>
		 		<p>주소  ${shippingInfo.shipping_addressName}(${shippingInfo.shipping_country})</p>
		 	</div>
		 	<div class="col-4" align="right">
		 		<p> <em>배송일 ${shippingInfo.shipping_shippingDate}</em> </p>
		 	</div>
		 	<div>
		 		<table class="table table-hover">
		 			<tr>
		 				<th class="text-center">상품</th>
		 				<th class="text-center">수량</th>
		 				<th class="text-center">가격</th>
		 				<th class="text-center">소계</th>
		 			
		 			</tr>
		 			
		 			
		 			<c:forEach var="row" items="${orderList}">
					<c:set var="sum" value="${row.quantity * row.P_UNITPRICE}"/>
					<c:set var="totalSum" value="${totalSum + sum}"/>
						<tr>
							<td class="text-center"><em>${row.P_NAME}</em></td>
							<td class="text-center"><fmt:formatNumber value="${row.quantity}" pattern="#,###" /></td>
							<td class="text-center"><fmt:formatNumber value="${row.P_UNITPRICE}" pattern="#,###" /></td>
							<td class="text-center"> ₩ <fmt:formatNumber value="${row.total}" pattern="#,###" /></td>
						
						</tr>
		 			</c:forEach>
					
		 				<tr>
		 					<td> &nbsp; </td>
		 					<td> &nbsp; </td>
		 					<td class="text-right"> <strong> 총액 </strong> </td>
		 					<td class="text-center text-danger"> <strong> <fmt:formatNumber value="${totalSum}" pattern="#,###" /> </strong> </td>
		 				</tr>
		 		</table>
		 		<a href="/shippingInfo?cartId=${session_id}" class="btn btn-secondary" role="button">이전</a>
		 		<a href="/thankCustomer" class="btn btn-success" role="button">주문 완료</a>
		 		<a href="/checkOutCancelled" class="btn btn-secondary" role="button">취소</a>
		 	</div>
		 </div>
	</div>
	


</body>
</html>