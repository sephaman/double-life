<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Create Bet Event</title>
</head>
<body>
<h1>
	Create Bet Event
</h1>
<form:form method="POST" commandName="betEvent">
	<table>
		<tr>
			<td>Bet Event Type :</td>
			<td><form:select path="betEventTypeId">
				<form:options items="${lstBetEventTypes}" itemValue="id" itemLabel="name"/>
				</form:select>
			</td>
			</tr>
			<tr>
				<td>Date :</td>
				<td>
					<form:input path="dateTime"/>
				</td>
			</tr>
			<tr>
				<td>Event Name :</td>
				<td>
					<form:input path="betEventName"/>
				</td>
			</tr>
			<tr>
				<td>Select Participants :</td>
				<td><form:select path="">
					<form:options items="${lstParticipants}" itemValue="id" itemLabel="name"/>
					</form:select>
				</td>
				<td>
					<input type="button" value="add" onclick="alert('hello')"/>
				</td>
			</tr>
			<tr>
			<tr>
				<td>
					Participants
				</td>
				<td>
					<select id="participantList" multiple="multiple" >
						
					</select>
				</td>
			
			</tr>
		
		
		<tr>
			<td colspan="2"><input type="submit" value="Create Bet Event"></td>
		</tr>
	</table>
</form:form>
</body>
</html>
