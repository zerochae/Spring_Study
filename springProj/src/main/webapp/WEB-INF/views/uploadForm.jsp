<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>

	<form action="/uploadFormAction" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" multiple/>
		<input type="submit" value="uploadFormAction">
	</form>
	

</body>
</html>