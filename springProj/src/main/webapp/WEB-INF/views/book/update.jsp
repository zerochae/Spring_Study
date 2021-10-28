<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<style> 

h1,h2,h3,h4,h5,p,span{
transform : rotate(0.04deg);
}

</style>

<title> 책 수정하기 </title>
</head>
<body>

<h1> 책 수정 </h1>

<form method ="post">
	
	<p> 제목  <input type="text" name="title" value="${data.TITLE}"/> </p>
	<p> 카테고리  <input type="text" name="category" value="${data.CATEGORY }"/> </p>
	<p> 가격  <input type="text" name="price" value="${data.PRICE }"/> </p>
	<p>  <input type="submit" value="저장"/> </p>

</form>

</body>
</html>