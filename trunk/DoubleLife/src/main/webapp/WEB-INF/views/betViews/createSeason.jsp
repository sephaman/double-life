<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Create Season</title>
</head>
<body>
<h1>
	Create Season
</h1>
<form:form method="POST" commandName="season" name="sbtForm" id="sbtForm">
	<table>
		<tr>
			<td>Bet Event Type :</td>
			<td><form:select path="betEventTypeId">
				<form:options items="${lstBetEventTypes}" itemValue="id" itemLabel="name"/>
				</form:select>
			</td>
			</tr>
			<tr>
				<td>Season Name :</td>
				<td>
					<form:input path="seasonName" name="seasonName"/>
				</td>
			</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Create Season" name="submitBtn" id="submitBtn"/>
			</td>
		</tr>
	</table>
	<form:hidden path="" name="submissionType" id="submissionType" value=""/>
</form:form>
</body>
</html>
