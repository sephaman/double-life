<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Bets</title>
</head>
<body>
	<div class="body_header">
		User Bets
	</div>
	<div class="regular_table">
		<table>
			<thead>
				<tr>
					<th>Bet Id</th><th>Bet Event Id</th><th>Value</th><th>Stake</th><th>Odds</th><th>Date</th><th>Money Paid</th>
				</tr>
			</thead>
			<tbody>
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
			</tbody>
		</table>
	</div>
</body>
</html>
