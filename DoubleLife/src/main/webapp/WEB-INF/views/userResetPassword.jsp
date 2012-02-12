<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Tip n' Trade</title>
</head>
<body>
<div class="body_header">
	Change Password
</div>

<c:if test="${not empty success}"> 
	<c:if test="${success == true}">
		<p style="color: green;">Password successfully changed! </p>
	  </c:if>
</c:if>

<c:if test="${empty success or success == false}"> 
<c:if test="${not empty errorMsg}">
	<p style="color: red;">${errorMsg}</p>
</c:if>
	<form action="resetUserPwdSubmit.htm" method="post">
	
		<table class="regular_table">
			<tr>
				<td>Current Password:</td><td><input name="currentPwd" id="currentPwd"/></td>
			</tr>
			<tr>
				<td>New Password:</td><td><input name="newPwd" id="newPwd"/></td>
			</tr>
			<tr>
				<td>Confirm Password:</td><td><input name="confirmPwd" id="confirmPwd"/></td>
			</tr>
		</table>
		
		<input type="submit" name="sbmtBtn" id="sbmtBtn" value="Submit" />
	</form>
</c:if>
</body>
</html>
