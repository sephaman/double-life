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
<form id="frmSubmit" method="post" action="createBetEvent.htm">
		<input id="stkCode" type="text" name="stkCode" />
		<input id="btnOK"  type="submit" value="Submit"/>
	</form>
</body>
</html>