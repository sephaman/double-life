<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Search</title>
</head>
<body>
<div class="body_header">
	Stock Search
</div>
	<form id="frmSubmit" method="post" action="stockSearch.htm">
		<input id="stkCode" type="text" name="stkCode" />
		<input id="btnOK"  type="submit" value="Submit"/>
	</form>
	
	<c:if test="${not empty stock}">
		<div class="regular_table">
			<table>
				<thead>
					<tr>
						<th>Code</th>
						<th>Name</th>
						<th>Price</th>
						<th/>
						<th/>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${stock.stockCode}</td>
						<td>${stock.stockName}</td>
						<td>${stock.currentPrice}</td>
						<td><a id="buyStockLink" href="orderStock.htm?stkCode=${stock.stockCode}&action=buy">Buy</a></td>
						<td><a id="sellStockLink" href="orderStock.htm?stkCode=${stock.stockCode}&action=sell">Sell</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
	${noResult}
</body>
</html>
