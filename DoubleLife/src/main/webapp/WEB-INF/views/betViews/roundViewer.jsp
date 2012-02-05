<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Round Viewer</title>
</head>
<body>
<div class="body_header">
	 ${thisRound.roundName}
</div>
<br/>
Bet Events
<div class="regular_table">
	<table>
		<thead>
			<tr>
				<th>Wager</th><th>Tip</th><th>Event</th><th>Tip</th><th>Wager</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${betEvents}" var="thisBetEvent">
				<tr>
					<td><input id="homeWager-${thisBetEvent.id}" name="homeWager-${thisBetEvent.id}" value=""/></td>
					<td><input id="tip-${thisBetEvent.id}" name="tip-${thisBetEvent.id}" type="radio"/></td>
					<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
					<td><input id="tip-${thisBetEvent.id}" name="tip-${thisBetEvent.id}" type="radio"/></td>
					<td><input id="awayWager-${thisBetEvent.id}" name="awayWager-${thisBetEvent.id}" value=""/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
