<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bet Leaderboard</title>
</head>
<body>
<h1>
	Competition Leaderboard
</h1>

<c:if test="${not empty leaderboard}">
	<table>
	<c:forEach items="${leaderboard}" var="thisUser">
		<tr>
			<td valign="middle" style="font-size: normal">
				${thisUser.key.userName} - ${thisUser.value}
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
