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

<title> 책 등록하기 </title>
</head>
<body>

<h1> 책 등록 </h1>

<form action="/create" method ="post">

	<p> 제목  <input type="text" name="title"/> </p>
	<p> 카테고리  <input type="text" name="category"/> </p>
	<p> 가격  <input type="text" name="price"/> </p>
	<p>  <input type="submit" value="저장"/> </p>

</form>

</body>
</html>