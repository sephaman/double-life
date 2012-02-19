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
<br/>
<div align="center" class="body_paragraph">
	<p>
		Welcome to Fantasy Betting! Don't just pick your teams...bet on them!<br/>
		Join in the fun to battle against others in putting a stake on AFL games with real betting odds!
	</p>
	<img src="<c:url value="/resources/img/headtohead.jpg"/>" width="210" height="130" alt="headtohead"/>


<h3>
<img src="<c:url value="/resources/img/aflfooty.jpg"/>" width="60" height="60" alt="aflfooty"/> View and put in tips for next round! ->
<a id="round-${currentRound.id}" href="roundViewer.htm?id=${currentRound.id}&compId=${betComp.id}">${currentRound.roundName}</a>
</h3>
</div>	
</body>
</html>
