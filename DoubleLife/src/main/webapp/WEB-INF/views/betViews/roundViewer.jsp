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
		<c:forEach items="${betEvents}" var="thisBetEvent">
			<tr>
				<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
