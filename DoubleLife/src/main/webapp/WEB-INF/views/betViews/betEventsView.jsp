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
	<c:forEach items="${betEvents}" var="thisBetEvent">
		<tr>
			<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
			<td><a id="betEventUpdate-${thisBetEvent.id}" href="betEventUpdate.htm?id=${thisBetEvent.id}">update</a></td>
			<td><a id="betEventWinSelect-${thisBetEvent.id}" href="betEventWinSelect.htm?id=${thisBetEvent.id}">Select Winner</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
