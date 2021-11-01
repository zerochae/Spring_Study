<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LIST</title>
</head>
<body>

	<h1>요청 처리 연습</h1>

	<a href="member/register?userId=hongkd&password=1234">register?userId=hongkd&password=1234</a>


	<form action="/register01" method="post">
		<p>
			userId : <input type="text" name="userId" value="세균맨"/>
			password : <input type="password" name="password" value="1234"/>
			coin : <input type="text" name="coin" value="100"/>
			<input type="submit" value=register01/>
		</p>
	</form>

</body>
</html>