<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"> 
<link rel="stylesheet" href="/resources/css/sb-admin-2.css"> 
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script> 
<script type="text/javascript" src="/resources/js/sb-admin-2.js"></script> 
<head>
   <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<title><tiles:insertAttribute name="title" /></title>
<!-- <link rel="stylesheet" href="/resources/css/tiles.css"> -->
</head>
<body>
	<tiles:insertAttribute name="header"/>
		<div> 
			<tiles:insertAttribute name="aside" />
			<tiles:insertAttribute name="body" />
		</div> 
	<tiles:insertAttribute name="footer"/>
	 <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
	
</body>
</html>