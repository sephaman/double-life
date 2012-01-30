<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="header" class="menuHeader">
	<table width="100%" border="0">
	
		<tr>
			<td style="font-color:white">
				${betComp.name}
			</td>
		</tr>
	
		<!-- Side Menu -->
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="betAccountLink" href="userBetAccount.htm" class="menuLink">View Betting Account</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="joinBetCompLink" href="betCompsView.htm" class="menuLink">Join Competition</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="createBetCompLink" href="betCompsCreate.htm" class="menuLink">Create Competition</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewBetEvents" href="betEventsView.htm" class="menuLink">View Bet Events</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewUserBets" href="userBets.htm" class="menuLink">View User Bet</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="createBetEvent" href="createBetEvent.htm" class="menuLink">Create Bet Event</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewCompLeaderboard" href="betCompLeaderboardView.htm?id=1" class="menuLink">View Comp Leaderboard</a>
			</td>
		</tr>
		<c:if test="${rolename == 'ROLE_ADMIN'}">
			<tr>
				<td valign="middle" style="font-size: normal" class="button">
						<a id="createSeason" href="createSeason.htm" class="menuLink">Create Season</a>
				</td>
			</tr>
			<tr>
				<td valign="middle" style="font-size: normal" class="button">
						<a id="createRound" href="createRound.htm" class="menuLink">Create Round</a>
				</td>
			</tr>
			<tr>
				<td valign="middle" style="font-size: normal" class="button">
						<a id="viewSeasons" href="viewSeasons.htm" class="menuLink">View Seasons</a>
				</td>
			</tr>
		</c:if>
	</table>
</div>
