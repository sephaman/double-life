<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>All Seasons</title>
</head>
<body>
<div class="body_header">
	All Seasons
</div>
<table>
		<c:forEach items="${lstSeasons}" var="thisSeason">
			<tr>
			<td><a id="season-${thisSeason.id}" href="seasonViewer.htm?id=${thisSeason.id}">${thisSeason.seasonName}</a></td>
		</tr>
		</c:forEach>
</table>

</body>
</html>
