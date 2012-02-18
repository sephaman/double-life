<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Tip n' Trade</title>
</head>
<body>
<img src="<c:url value="/resources/img/tipntradeHeader2.jpg"/>" alt="header logo" width="170" height="70" alt="tipNtrade"/>
<h1>
	Forgot your password?
</h1>
<c:if test="${success == true }">
	Email has been sent to ${user.emailAddress}!
</c:if>
<c:if test="${success == false }">
	${errorMsg}
</c:if>
<c:if test="${empty success}">
	<p>
		Please enter your email address below to have your login details reset and emailed to you.
	</p>
	
	<form:form method="POST" commandName="user">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="emailAddress" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</c:if>
<br/>
<a id="loginLink" href="login.htm">Return To Login</a>
</body>
</html>
