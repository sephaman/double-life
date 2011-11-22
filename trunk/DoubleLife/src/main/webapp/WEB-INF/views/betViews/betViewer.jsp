<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<h1>
	Bet Viewer
</h1>
<form id="submitForm" method="POST" action="betViewer.htm">
<input type="hidden" name="betEventId" value="${betEvent.id}">
<table>
	<tr>
		<td>${betEvent.betEventName}</td>
	</tr>
		<c:forEach items="${betParticipants}" var="thisBetParticipant">
		<tr>
			<td>${thisBetParticipant.key.name} - ${thisBetParticipant.value}</td>
			<td><input id="betSelect-${thisBetParticipant.key.id}"  name="betSelect" type="radio" value="${thisBetParticipant.key.id}:${thisBetParticipant.value}"/></td>
		</tr>
		</c:forEach>
	<tr>
		<td>Stake</td><td><input id="stake" name="stake" type="text" /></td>
	</tr>
	<tr>
		<td><input id="btnSubmit" class="button" type="submit" value="Submit"/></td>
	</tr>
</table>
</form>

</body>
</html>
