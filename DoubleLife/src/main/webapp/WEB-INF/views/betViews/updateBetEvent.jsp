<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Update Bet Event</title>
</head>
<body>
<h1>
	Update Bet Event
</h1>
<form:form method="POST" commandName="betEvent" name="sbtForm" id="sbtForm">
	<table>
		<tr>
			<td>Bet Event Type :</td>
			<td>${betEventType}</td>
		</tr>
			<tr>
				<td>Date :</td>
				<td>
					${betEvent.dateTime}
				</td>
			</tr>
			<tr>
				<td>Event Name :</td>
				<td>
					${betEventType.name}
				</td>
			</tr>
			<tr>
				<td>Participants :</td>
				<c:forEach items="${lstParticipant}" var="thisPart">
					<td>
					${thisPart.key.name}
					</td>
					<td>
						<form:input path="" name="part_price" id="part_price" value="${thisPart.value}"/>
						<form:hidden path="" name="id_price" id="id_price" value="${thisPart.key.id}:${thisPart.value}"/>
					</td>
				</c:forEach>
			</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Update Bet Event" name="submitBtn" id="submitBtn" />
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>
