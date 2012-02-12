<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Tip n' Trade</title>
</head>
<body>
<div class="body_header">
	User Details
</div>
<form action="resetUserPwd.htm" method="post">

	<table class="regular_table">
		<tr>
			<td>Username:</td><td>${user.userName}</td>
		</tr>
		<tr>
			<td>First name:</td><td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last name:</td><td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Email:</td><td>${user.emailAddress}</td>
		</tr>
		<tr>
			<td>Betting Account Value:</td><td>${userAccount_head}</td>
		</tr>
	</table>
	<input type="hidden" id="userId" name="userId" value="${user.id}"/>
	<input type="submit" id="resetSbmt" name="resetSbmt" value="Change Password"/>
</form> 

</body>
</html>
