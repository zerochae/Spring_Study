<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guestbook/fileupload02.jsp</title>
</head>
<body>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="fileupload02_process.jsp">
		<p> 이름1 : <input type="text" name="name1" /> 
			제목1 : <input type="text" name="subject1" /> 
			파일1 : <input type="file" name="filename1" /> </p>
		<p> 이름2 : <input type="text" name="name2" /> 
			제목2 : <input type="text" name="subject2" /> 
			파일2 : <input type="file" name="filename2" /> </p>
		<p> 이름3 : <input type="text" name="name3" /> 
			제목3 : <input type="text" name="subject3" /> 
			파일3 : <input type="file" name="filename3" /> </p>
		<p> <input type="submit" value="파일 올리기" /> </p>
	</form>

</body>
</html>