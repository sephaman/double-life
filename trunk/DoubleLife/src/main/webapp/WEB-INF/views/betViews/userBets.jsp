<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Bets</title>
</head>
<body>
	<h1>
		User Bets
	</h1>
	<table>
		<c:forEach items="${userBets}" var="thisBet">
		<tr>
			<td>${thisBet.key.id}</td>
			<td>${thisBet.key.betEventId}</td>
			<td>${thisBet.value}</td>
			<td>${thisBet.key.stake}</td>
			<td>${thisBet.key.odds}</td>
			<td>${thisBet.key.dateReceived}</td>
			<td>${thisBet.key.moneyPaid}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
