<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Fantasy Betting Home</title>
</head>
<body>
<div class="body_header">
	Fantasy Betting
</div>

<h2>
	View and put in tips for next round!
</h2>
<br/>
	<a id="round-${currentRound.id}" href="roundViewer.htm?id=${currentRound.id}&compId=${betComp.id}">${currentRound.roundName}</a>

</body>
</html>
