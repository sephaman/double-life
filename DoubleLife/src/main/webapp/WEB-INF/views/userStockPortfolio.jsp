<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	User Portfolio!
</h1>
<c:forEach items="${stockMap}" var="thisStockItem">
		<tr>
			<td valign="middle" style="font-size: normal">
				${thisStockItem}
			</td>
		</tr>
	</c:forEach>
</body>
</html>
