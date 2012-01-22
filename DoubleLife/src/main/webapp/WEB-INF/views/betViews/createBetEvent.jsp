<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Create Bet Event</title>
</head>
<body>
<script type="text/javascript">
	function submitter(buttonSubmit) {
		 var hiddenField = document.getElementById('submissionType');
		 hiddenField.value = buttonSubmit;
		 var form = document.getElementById('sbtForm');
		 form.submit();
	}
</script>
<h1>
	Create Bet Event
</h1>
<form:form method="POST" commandName="betEvent" name="sbtForm" id="sbtForm">
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
					<form:input path=""/>
				</td>
			</tr>
			<tr>
				<td>Event Name :</td>
				<td>
					<form:input path="betEventName" name="betEventName"/>
				</td>
			</tr>
			<tr>
				<td>Select Participants :</td>
				<td><form:select path="" name="participantSelect" id="participantSelect">
					<form:options items="${lstParticipants}" itemValue="id" itemLabel="name"/>
					</form:select>
				</td>
				<td>
					Price
				</td>
				<td>
					<form:input path="" name="part_price" id="part_price"/>
				</td>
				<td>
					<input id="addParticipant" name="addParticipant" type="button" value="add" onclick="submitter(this.value);"/>
				</td>
			</tr>
			<tr>
			<tr>
				<td>
					Participants
				</td>
				<td>
					<form:select id="participantList" multiple="multiple" path="">
						<form:options items="${selectedParticipants}" />
					</form:select>
				</td>
			
			</tr>
		<tr>
			<td colspan="2"><input type="button" value="Create Bet Event" name="submitBtn" id="submitBtn" onclick="submitter(this.name);"/>
			</td>
		</tr>
	</table>
	<form:hidden path="" name="submissionType" id="submissionType" value=""/>
</form:form>
</body>
</html>
