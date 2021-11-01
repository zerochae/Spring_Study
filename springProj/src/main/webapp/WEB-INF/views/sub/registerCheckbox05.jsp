<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>체크박스 데이터가 boolean 타입인 경우</title>
</head>
<body>

<form action="/board/registerCheckbox05Post" method="post">

	<p> 외국인 여부 <input type="checkbox" name="foreigner" value="True"> </p>
	<input type="submit" value="registerCheckbox05">

</form>


</body>
</html>