<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<h1>
	Join Fantasy betting Competition
</h1>

<c:if test="${not empty betComps}">
	<table>
	<c:forEach items="${betComps}" var="thisBetComp">
		<tr>
			<td valign="middle" style="font-size: normal">
				<a id="${thisBetComp.id}" href="betCompsJoin.htm?id=${thisBetComp.id}">${thisBetComp.name}</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
