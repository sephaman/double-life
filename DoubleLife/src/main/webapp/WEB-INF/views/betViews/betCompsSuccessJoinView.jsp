<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<div class="body_header">
	Successfully Joined Competition
</div>

<c:if test="${registered == true}">
<br/>
<br/>
Successfully joined competition: ${joinedComp.name}
</c:if>
</body>
</html>
