<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>HOME.JSP</title>
</head>
<body>

<h1>HOME</h1>

<p>컨트롤러 응답 연습</p>

<p> return이 void일때 </p>
<a href="/goHome0101">요청 경로와 동일한 뷰 </a>
<a href="/goHome0102">요청 경로와 동일한 뷰 </a>
<p> return이 String일때 </p>
<a href="/goHome0201"> 반환값이 뷰를 가르킴1 </a>
<a href="/sub/goHome0202"> 반환값이 뷰를 가르킴2</a>
<p> 반환값이 redirect:로 시작하면 리다이렉트 방식으로 처리 한다</p>
<a href="goHome0204"> 리 다이트렉트 방식1 </a>
<a href="/sub/goHome0205"> 리 다이트렉트 방식1 </a>
</body>
</html>

