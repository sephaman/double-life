<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Create Bet Competition</title>
</head>
<body>
<h1>
	Create Bet Competition.
</h1>
<form:form method="POST" commandName="betCompetition">
	<table>
		<tr>
			<td>Competition Name :</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Starting Amount :</td>
			<td><form:input path="acctStartAmnt" value="1000.00"/></td>
			<td><form:errors path="acctStartAmnt" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Create Competition"></td>
		</tr>
	</table>
</form:form>
</body>
</html>
