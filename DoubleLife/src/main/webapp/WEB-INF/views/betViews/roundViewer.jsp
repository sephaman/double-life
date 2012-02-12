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
	<input type="hidden" name="compRulesId" id="compRulesId" value="${betCompRules.id}"/>
	<div id="msgDiv" style="color: red">
			<c:if test="${betSubmitted == true}">Bets submitted for this round.</c:if>
	</div>
	<div class="regular_table">
		<table width="75%">
			<thead>
				<tr>
					<th>Stake</th><th>Odds</th><th>Tip</th><th>Event</th><th>Tip</th><th>Odds</th><th>Stake</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${betEvents}" var="thisBetEvent">
					<tr>
						<td width="15%">
							<input id="homeWager-${thisBetEvent.betEventId}" name="homeWager-${thisBetEvent.betEventId}" 
							value="${thisBetEvent.selectionId == thisBetEvent.homeParticipantId ? thisBetEvent.betValue : 0.00}"
							<c:if test="${betSubmitted == true}">readonly</c:if>/>
						</td>
						<td width="15%">
							<input id="homeOdds-${thisBetEvent.betEventId}" name="homeOdds-${thisBetEvent.betEventId}" value="${thisBetEvent.homeOdds}" type="text" readonly/>
						</td>
						<td width="5%">
							<input id="tip-${thisBetEvent.betEventId}" name="tip-${thisBetEvent.betEventId}" type="radio" value="${thisBetEvent.homeParticipantId}" 
							<c:if test="${thisBetEvent.selectionId == thisBetEvent.homeParticipantId}">checked </c:if> 
							<c:if test="${betSubmitted == true}">disabled</c:if>/>
						</td>
						<td width="30%"><a id="betEvent-${thisBetEvent.betEventId}" href="betViewer.htm?id=${thisBetEvent.betEventId}">${thisBetEvent.betEventName}</a></td>
						<td width="5%">
							<input id="tip-${thisBetEvent.betEventId}" name="tip-${thisBetEvent.betEventId}" type="radio" value="${thisBetEvent.awayParticipantId}"
							<c:if test="${thisBetEvent.selectionId == thisBetEvent.awayParticipantId}">checked </c:if> 
							<c:if test="${betSubmitted == true}">disabled</c:if>/>
						</td>
						<td width="15%">
							<input id="awayOdds-${thisBetEvent.betEventId}" name="awayOdds-${thisBetEvent.betEventId}" value="${thisBetEvent.awayOdds}" type="text" readonly/>
						</td>
						<td width="15%">
							<input id="awayWager-${thisBetEvent.betEventId}" name="awayWager-${thisBetEvent.betEventId}" 
							value="${thisBetEvent.selectionId == thisBetEvent.awayParticipantId ? thisBetEvent.betValue : 0.00}"
							<c:if test="${betSubmitted == true}">readonly</c:if>/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
	<table width="100%">
	<tr>
		<td align="left"> <c:if test="${not empty prevRound}"><a id="round-${prevRound.id}" href="roundViewer.htm?id=${prevRound.id}&compId=${betComp.id}">${prevRound.roundName}</a></c:if></td>
		<td align="center"><input id="btnSubmit" type="submit" value="Submit" <c:if test="${betSubmitted == true}">disabled</c:if>/></td>
		<td align="right"> <c:if test="${not empty nextRound}"><a id="round-${nextRound.id}" href="roundViewer.htm?id=${nextRound.id}&compId=${betComp.id}">${nextRound.roundName}</a></c:if></td>
	</tr>
	</table>
	</div>
</form>
</body>
</html>
