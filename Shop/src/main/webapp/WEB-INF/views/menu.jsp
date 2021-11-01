<%@ page language="java" contentType="text/html; charset=UTF-8"%>

 <style> 
 h1,h2,h3,h4,p,span,strong{
 	transform : rotate(0.04deg)
}
 </style>
<%
request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js">
</script>
<nav class="navbar navbar-expand navbar-dark bg-dark"> 
	<div class="container">
		<div class="navbar-header">
		<a class="navbar-brand" href="/"> Home </a>
		<a class="navbar-brand" href="/addProduct"> Product </a>
		<div> 
		</div>
		</div>
	</div>
	<div>
		<ul class="navbar-nav mr-auto"> 
			<li class="nav-item"><a class="nav-link" href="/products">상품 목록</a></li>
			<li class="nav-item"><a class="nav-link" href="/addProduct">상품 등록</a></li>
			<li class="nav-item"><a class="nav-link" href="/editProduct?edit=update">상품 수정</a></li>
			<li class="nav-item"><a class="nav-link" href="/editProduct?edit=delete">상품 삭제</a></li>
		</ul>
	</div>
</nav>