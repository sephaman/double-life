<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<h1>
	Bet Events
</h1>
<table>
	<c:forEach items="${betEvents}" var="thisBetEvent">
		<tr>
			<td><a id="betEvent-${thisBetEvent.id}" href="betViewer.htm?id=${thisBetEvent.id}">${thisBetEvent.betEventName}</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
