<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">

	function deleteConfirm(id){
		if(confirm("해당 상품을 삭제합니다") == true){
			location.href = "/deleteProduct?id="+id;
		} else {
			return;
		}
	}

</script>
</head>
<body>

	<jsp:include page="menu.jsp" />

	<div class="jumbotron">
		<div class="container">
		<c:if test="${param.edit == 'update'}">
			<h1 class="display-3">상품 편집</h1>
		</c:if>
		
		<c:if test="${param.edit == 'delete'}">
			<h1 class="display-3">상품 삭제</h1>
		</c:if>
		</div>
	</div>

	<div class="container">
		<div class="row" align=center>
		
			<c:forEach var="row" items="${data}">
			<div class="col-md-4">
				<img alt="" src="/images/${row.P_FILENAME}" style=" width:100%; height: 240px">
				<h3> ${row.P_NAME} </h3>
				<p> ${row.P_DESCRIPTION} </p>
				<p> ₩  ${row.P_UNITPRICE} </p>
				<p>
					<c:if test="${param.edit == 'update'}">
					<a href="/updateProduct?id=${row.P_ID}" class="btn btn-success"
						role="button"> 수정 &raquo; </a>
					</c:if>
					<c:if test="${param.edit == 'delete'}">
					<a href="#" onclick="deleteConfirm('${row.P_ID}')" role="button" class="btn btn-danger">
						삭제 &raquo; </a>
					</c:if>
				</p>
			</div>
			</c:forEach>
	</div>
</div>
	<jsp:include page="footer.jsp" />


</body>
</html>