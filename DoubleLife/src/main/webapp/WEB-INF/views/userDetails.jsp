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
	<input type="hidden" id="userId" name="userId" value="${user.id}"/>
	<input type="submit" id="resetSbmt" name="resetSbmt" value="Change Password"/>
</form> 

</body>
</html>
