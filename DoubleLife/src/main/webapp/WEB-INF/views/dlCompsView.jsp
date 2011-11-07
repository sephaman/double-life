<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<h1>
	Join Fantasy Competition
</h1>

<c:if test="${not empty dlComps}">
	<table>
	<c:forEach items="${dlComps}" var="thisDlComp">
		<tr>
			<td valign="middle" style="font-size: normal">
				<a id="${thisDlComp.id}" href="dlCompsJoin.htm?id=${thisDlComp.id}">${thisDlComp.name}</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
