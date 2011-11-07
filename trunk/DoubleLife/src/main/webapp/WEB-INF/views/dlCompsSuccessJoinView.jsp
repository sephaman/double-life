<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Double Life Competition</title>
</head>
<body>
<h1>
	Successfully Joined Competition
</h1>

<c:if test="${registered == true}">
<br/>
<br/>
Successfully joined competition: ${joinedComp.name}
</c:if>
</body>
</html>
