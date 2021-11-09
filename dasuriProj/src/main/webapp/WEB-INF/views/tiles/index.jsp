<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<head>
<title><tiles:insertAttribute name="title" /></title>
<!-- <link rel="stylesheet" href="/resources/css/tiles.css"> -->
</head>
<body>
	<tiles:insertAttribute name="header"/>
		<div class="container">
			<tiles:insertAttribute name="aside" />
			<tiles:insertAttribute name="body" />
		</div> 
	<tiles:insertAttribute name="footer"/>

</body>
</html>