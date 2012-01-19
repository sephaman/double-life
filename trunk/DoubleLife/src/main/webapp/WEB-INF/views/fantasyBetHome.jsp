<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Fantasy Betting
</h1>
<table width="100%" border="0">
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="betAccountLink" href="userBetAccount.htm">View Betting Account</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="joinBetCompLink" href="betCompsView.htm">Join Competition</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="createBetCompLink" href="betCompsCreate.htm">Create Competition</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="viewBetEvents" href="betEventsView.htm">View Bet Events</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="viewUserBets" href="userBets.htm">View User Bet</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="createBetEvent" href="createBetEvent.htm">Create Bet Event</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="viewCompLeaderboard" href="betCompLeaderboardView.htm?id=1">View Comp Leaderboard</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal">
					<a id="createSeason" href="createSeason.htm">Create Season</a>
			</td>
		</tr>
	</table>
</body>
</html>
