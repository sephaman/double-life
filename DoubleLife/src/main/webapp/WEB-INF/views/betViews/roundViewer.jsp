<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Round Viewer</title>
</head>
<body>
<h1>
	Round Viewer - ${thisRound.roundName}  - Round Number - ${thisRound.roundSequenceNumber}
</h1>
<table>
<tr>
	<td>
		Bet Events
	</td>
</tr>
		<c:forEach items="${betEvents}" var="thisBetEvent">
		<tr>
			<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
