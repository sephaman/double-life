<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Tip n' Trade</title>
</head>
<body>
<img src="<c:url value="/resources/img/tipntradeHeader.jpg"/>" alt="header logo" width="170" height="70" alt="tipNtrade"/>
<h1>
	User Registration
</h1>

<form:form method="POST" commandName="user">
	<table>
		<tr>
			<td>User Name :</td>
			<td><form:input path="userName" /></td>
			<td><form:errors path="userName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>First Name :</td>
			<td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><form:input path="lastName" /></td>
			<td><form:errors path="lastName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="emailAddress" /></td>
			<td><form:errors path="emailAddress" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
</body>
</html>