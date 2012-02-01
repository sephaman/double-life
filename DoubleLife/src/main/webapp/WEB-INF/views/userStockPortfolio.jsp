<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="body_header">
	User Stock Portfolio
</div>
<div class="regular_table">
	<table>
		<thead>
			<tr>
				<th>StockCode</th><th>Name</th><th>Quantity</th><th>Cost Basis</th><th>Current Price</th><th>Date Acquired</th>
			</tr>
		</thead>
			<c:forEach items="${stockMap}" var="thisStockItem">
				<tr>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.key.stockCode}
					</td>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.value.stockName}
					</td>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.key.quantityHeld}
					</td>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.key.costBasis}
					</td>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.value.currentPrice}
					</td>
					<td valign="middle" style="font-size: normal">
						${thisStockItem.key.dateAcquired}
					</td>
				</tr>
			</c:forEach>
	</table>
</div>
</body>
</html>
