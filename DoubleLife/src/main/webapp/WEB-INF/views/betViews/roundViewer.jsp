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
<h3>
Bet Events
</h3>
<form id="frmSubmit" method="post" action="roundViewer.htm">
<input type="hidden" name="roundId" id="roundId" value="${thisRound.id}"/>
<div class="regular_table">
	<table>
		<thead>
			<tr>
				<th>Stake</th><th>Odds</th><th>Tip</th><th>Event</th><th>Tip</th><th>Odds</th><th>Stake</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${betEvents}" var="thisBetEvent">
				<tr>
					<td><input id="homeWager-${thisBetEvent.betEventId}" name="homeWager-${thisBetEvent.betEventId}" value=""/></td>
					<td>${thisBetEvent.homeOdds}</td>
					<td><input id="tip-${thisBetEvent.betEventId}" name="tip-${thisBetEvent.betEventId}" type="radio" value="${thisBetEvent.homeParticipantId}"/></td>
					<td><a id="betEvent-${thisBetEvent.betEventId}" href="betViewer.htm?id=${thisBetEvent.betEventId}">${thisBetEvent.betEventName}</a></td>
					<td><input id="tip-${thisBetEvent.betEventId}" name="tip-${thisBetEvent.betEventId}" type="radio" value="${thisBetEvent.awayParticipantId}"/></td>
					<td>${thisBetEvent.awayOdds}</td>
					<td><input id="awayWager-${thisBetEvent.betEventId}" name="awayWager-${thisBetEvent.betEventId}" value=""/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input id="btnSubmit"  type="submit" value="Submit"/>
</div>
</form>
</body>
</html>
