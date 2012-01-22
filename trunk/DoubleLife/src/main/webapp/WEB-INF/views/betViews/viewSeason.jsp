<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Season Viewer</title>
</head>
<body>
<h1>
	Season Viewer - ${thisSeason.seasonName}
</h1>
<table>
<tr>
	<td>
		Rounds
	</td>
</tr>
		<c:forEach items="${rounds}" var="thisRound">
			<tr>
				<td><a id="round-${thisRound.id}" href="roundViewer.htm?id=${thisRound.id}">${thisRound.roundName}</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>
					<input type="submit" name="addRoundBtn" id="addRoundBtn" value="Add New Round" onclick=""/>
			</td>
		</tr>
</table>

</body>
</html>
