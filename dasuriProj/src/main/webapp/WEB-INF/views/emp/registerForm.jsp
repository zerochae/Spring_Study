<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>/emp/registerForm.jsp</title>
</head>
<body>
<h2>Spring Form</h2>
<form:form modelAttribute="member" method="post" action="/emp/register">
<table> 
	<form:hidden path="userId"/>
	<tr>
		<td> <form:label path="userId"> 유저ID </form:label></td>
		<td> <form:input path="userId"/><font color="red"> <form:errors path="userId" /></font> </td>
	</tr>
	<tr>
		<td><form:label path="userName"> 이름 </form:label></td>
		<td> <form:input path="userName"/><font color="red"> <form:errors paht="userName"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="email"> E-MAIL</form:label></td>
		<td> <form:input path="email"/><font color="red"> <form:errors paht="email"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="password"> 패스워드 </form:label></td>
		<td> <form:input path="password"/><font color="red"> <form:errors paht="password"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="introduction"> 소개  </form:label></td>
		<td> <form:textarea rows="6" cols="30" path="introduction"/><font color="red"> <form:errors paht="password"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="hobbyList"> 취미  </form:label></td>
		<td> <form:checkboxes path="hobbyList" items="${hobbyMap}"/>
		<font color="red"> <form:errors paht="hobby"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="developer"> 개발자여부  </form:label></td>
		<td> <form:checkbox path="developer" value="Y"/>
		<font color="red"> <form:errors paht="developer"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="foreigner"> 외국인여부  </form:label></td>
		<td> <form:checkbox path="foreigner" value="false"/>
		<font color="red"> <form:errors paht="foreigner"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="gender"> 성별  </form:label></td>
		<td> <form:radiobuttons path="gender" items="${genderCodeMap}"/>
		<font color="red"> <form:errors paht="gender"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="nationality"> 국적  </form:label></td>
		<td> <form:select path="nationality" items="${nationalityCodeMap}"/>
		<font color="red"> <form:errors paht="nationality"/> </font> </td>
	</tr>
	<tr>
		<td><form:label path="carList"> 소유차량  </form:label></td>
		<td> <form:select path="carList" items="${carCodeMap}" multiple="true"/>
		<font color="red"> <form:errors paht="carList"/> </font> </td>
	</tr>
</table>

	<form:button name="register" class="btn btn-primary"> 등록 </form:button> 
</form:form>
</body>
</html>