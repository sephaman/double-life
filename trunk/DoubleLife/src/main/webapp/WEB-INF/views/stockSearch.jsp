<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Stock Search
</h1>	
	<form id="frmSubmit" method="post" action="stockSearch.htm">
		<input id="some" type="text" name="stockCode" />
		<input id="btnOK"  type="submit" value="Submit"/>
	</form>
	
	${stock.currentPrice}
	
	${noResult}

</body>
</html>
