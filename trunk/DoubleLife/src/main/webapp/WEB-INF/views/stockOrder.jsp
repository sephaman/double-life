<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Order</title>
</head>
<body>
<h1>
	Stock Order
</h1>

<form:form method="POST" commandName="stockOrder">
	<table>
		<tr>
			<td>Stock Code:</td>
			<td><form:input path="stockCode"/></td>
			<td><form:errors path="stockCode" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Action:</td>
			<td>${stockOrder.isBuyOrder == 1 ? 'BUY' : 'SELL'}</td>
		</tr>
		<tr>
			<td>Last Price: </td>
			<td> ${stock.currentPrice}</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td><form:input path="quantity" value="0"/></td>
			<td><form:errors path="quantity" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="orderPrice" /></td>
			<td><form:errors path="orderPrice" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>
