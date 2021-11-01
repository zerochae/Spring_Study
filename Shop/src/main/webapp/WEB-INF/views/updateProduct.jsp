<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>상품 수정</title>
</head>
<style>

.condition-box input{
	margin-right : 5px;
	vertical-align: text-top;
}

</style>
<body>

	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 수정</h1>
		</div>
	</div>
	
	<div class="container">

		<div class="row">
			<div class="col-md-5">
				<img alt="" src="/images/${data.P_FILENAME}" style="width: 100%">
			</div>
			<div class="col-md-7">


				<form name="newProduct" action="processUpdateProduct.jsp"
					class="form-horizontal" method="post" enctype="multipart/form-data">
					<div class="form-group row">
						<label class="col-sm-2">상품 코드</label>
						<div class="col-sm-3">
							<input type="text" name="productId" id="productId"
								class="form-control" value="${data.P_ID}" readonly/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 상품명 </label>
						<div class="col-sm-3">
							<input type="text" name="name" id="name" class="form-control"
								value="${data.P_NAME}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 가격 </label>
						<div class="col-sm-3">
							<input type="text" name="unitPrice" id="unitPrice"
								class="form-control" value="${data.P_UNITPRICE}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 상세 설명 </label>
						<div class="col-sm-3">
							<textarea name="description" cols="50" rows="2"
								class="form-control">${data.P_description}</textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 제조사 </label>
						<div class="col-sm-3">
							<input type="text" name="manufacturer" class="form-control"
								value="${data.P_manufacturer}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">카테고리</label>
						<div class="col-sm-3">
							<input type="text" name="category" class="form-control"
								value="${data.P_CATEGORY}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">재고 </label>
						<div class="col-sm-3">
							<input type="text" name="unitsInStock" id="unitsInStock"
								class="form-control" value="${data.P_unitsInStock}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 상태 </label>
						<div class="col-sm-3">
							<div class="condition-box" style="display: inline-flex;">
							<c:set var="lth" value='${data.P_CONDITION}' />
							<input type="radio" name="condition" value="New" <c:if test="${lth eq 'new'}">checked </c:if> > NEW 
							<input type="radio" name="condition" value="Old" <c:if test="${lth eq 'OLD'}">checked </c:if> > OLD
							<input type="radio" name="condition" value="Refurbished" <c:if test="${lth eq 'REFURBISHED'}">checked </c:if> > REFURBISHED
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2"> 이미지 </label>
						<div class="col-sm-5">
							<input type="file" name="productImage" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="등록">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<jsp:include page="footer.jsp" />

</body>
</html>