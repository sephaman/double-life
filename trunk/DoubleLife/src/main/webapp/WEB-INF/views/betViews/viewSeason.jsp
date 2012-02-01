<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Season Viewer</title>
</head>
<body>
<div class="body_header">
	 ${thisSeason.seasonName}
</div>
<div class="regular_table">
	<table>
		<tr>
			<td>
				Rounds
			</td>
		</tr>
			<c:forEach items="${roundsmap}" var="thisRoundLst">
				<tr>
					<c:forEach items="${thisRoundLst.value}" var="thisRound">
					
						<td><a id="round-${thisRound.id}" href="roundViewer.htm?id=${thisRound.id}">${thisRound.roundName}</a></td>
					
					</c:forEach>
				</tr>
			</c:forEach>
			<tr>
				<td>
						<input type="submit" name="addRoundBtn" id="addRoundBtn" value="Add New Round" onclick=""/>
				</td>
			</tr>
	</table>
</div>
</body>
</html>
