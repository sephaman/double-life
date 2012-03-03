<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bet Events</title>
</head>
<body>
<div class="body_header">
	Bet Events
</div>
<table class="regular_table">
	<thead>
		<tr>
			<th>Bet Event Id</th>
			<th>Round Id</th>
			<th>Event Name</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${betEvents}" var="thisBetEvent">
		<tr>
			<td>${thisBetEvent.id}</td>
			<td>${thisBetEvent.parentRoundId}</td>
			<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
			<td>
				<c:if test="${thisBetEvent.selectionWinnerId == -1}">
					<a id="betEventUpdate-${thisBetEvent.id}" href="betEventUpdate.htm?id=${thisBetEvent.id}">update</a>
				</c:if>
			</td>
			<td>
				<c:if test="${thisBetEvent.selectionWinnerId == -1}">
					<a id="betEventWinSelect-${thisBetEvent.id}" href="betEventWinSelect.htm?id=${thisBetEvent.id}">Select Winner</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<div align="center">
	<form action="processPendingBets.htm" method="post" id="frmSubmit">
		<input type="submit" value="Process Bets" id="sbmtButton" name="sbmtButton"/>
	</form>
</div>
<div id="msgDiv" align="center" style="color:red">
	<c:if test="${not empty betsProcessed}">
		Number of bets processed: ${betsProcessed}
	</c:if>
	<c:if test="${betsToProcessExist == true}">
		Bet Events are ready to be processed!
	</c:if>
</div>
</body>
</html>
