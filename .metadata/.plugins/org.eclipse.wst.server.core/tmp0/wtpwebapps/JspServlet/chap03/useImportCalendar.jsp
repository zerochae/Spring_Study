<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%!
/*
private static Calendar instance = new Calendar();
public static Calendar getInstance(){
	return instance;
}
private Calendar(){};
*/
%>
<head>
<meta charset="UTF-8">
<title>Calendar 클래스 사용</title>
</head>
<body>
 
<%
	Calendar cal = Calendar.getInstance();
%>
오늘은
	<%=cal.get(Calendar.YEAR)%>년
	<%=cal.get(Calendar.MONTH) + 1%>월
	<%=cal.get(Calendar.DATE)%>일
입니다.
 
</body> 
</html>