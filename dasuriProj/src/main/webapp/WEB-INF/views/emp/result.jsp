<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<h3>Result</h3>

	<table>
		<tr>
			<th>유저ID</th>
			<td>${member.userId}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.userName}</td>
		</tr>
		<tr>
			<th>E-mail</th>
			<td>${member.email}</td>
		</tr>
		<tr>
			<th>password</th>
			<td>${member.password}</td>
		</tr>
		<tr>
			<th>introduction</th>
			<td>${member.introduction}</td>
		</tr>
		<tr>
			<th>hobby</th>
			<c:forEach var="hobby" items="${member.hobbyList}">
				<c:out value="${hobby}"></c:out>
			</c:forEach>
		</tr>
		<tr>
			<th>개발자여부</th>
			<td>${member.developer}</td>
		</tr>
		<tr>
			<th>외국인여부</th>
			<td>${member.foreigner}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<c:choose>
					<c:when test="${member.gender eq 'Male'}">남성</c:when>
					<c:when test="${member.gender eq 'Female'}">여성</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>국적</th>
			<td>
				<c:choose>
					<c:when test="${member.nationality eq '01'}">한국</c:when>
					<c:when test="${member.nationality eq '02'}">중국</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th> 소유자동차 </th>
			<td>
				<c:forEach var="car" items="${member.carList}">
					<c:choose>
						<c:when test="${car eq '01'}">르노</c:when>
						<c:when test="${car eq '02'}">현대</c:when>
						<c:when test="${car eq '03'}">상용</c:when>
					</c:choose>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>