<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Create Round</title>
</head>
<body>
<h1>
	Create Round
</h1>
<form:form method="POST" commandName="round" name="sbtForm" id="sbtForm">
	<table>
		<tr>
			<td>Bet Event Type :</td>
			<td><form:select path="seasonid">
				<form:options items="${lstSeasons}" itemValue="id" itemLabel="seasonName"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Round Name :</td>
			<td>
				<form:input path="roundName" name="roundName"/>
			</td>
		</tr>
		<tr>
			<td>Round Sequence :</td>
			<td>
				<form:input path="roundSequenceNumber" name="roundSequenceNumber"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Create Round" name="submitBtn" id="submitBtn"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>
