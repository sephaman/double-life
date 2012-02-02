<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bet Leaderboard</title>
</head>
<body>
<div class="body_header">
	Competition Leaderboard
</div>

<c:if test="${not empty leaderboard}">
	<table class="regular_table">
		<thead>
			<tr>
				<th>User</th><th>Amount</th>
			</tr>
		</thead>
	<c:forEach items="${leaderboard}" var="thisUser">
		<tr>
			<td valign="middle" style="font-size: normal">
				${thisUser.key.userName}
			</td>
			<td>
				${thisUser.value}
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
