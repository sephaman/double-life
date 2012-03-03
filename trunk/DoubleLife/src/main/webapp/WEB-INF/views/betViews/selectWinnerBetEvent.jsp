<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Select Winner For Bet Event</title>
</head>
<body>
<h1>
	Select Winner For Bet Event
</h1>
<form:form method="POST" commandName="betEvent" name="sbtForm" id="sbtForm">
	<table class="regular_table">
			<tr>
				<td>Participants :</td>
				<c:forEach items="${lstParticipant}" var="thisPart">
					<td>
					${thisPart.name}<form:radiobutton path="" name="winner" id="winner" value="${thisPart.id}"/>&nbsp;&nbsp;
					</td>
				</c:forEach>
					<td>
					Draw <form:radiobutton path="" name="winner" id="winner" value="-999"/>
					</td>
				</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Update Bet Event" name="submitBtn" id="submitBtn" />
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>
