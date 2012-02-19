<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="sidemenu">
	<table width="100%" border="0">
	
	
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
					<a id="viewUserBets" href="userBets.htm" class="menuLink">View User Bet</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewCompLeaderboard" href="betCompLeaderboardView.htm?id=1" class="menuLink">View Comp Leaderboard</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewSeasons" href="viewSeasons.htm" class="menuLink">View Seasons</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewUserDetails" href="userDetails.htm" class="menuLink">User Details</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewForum" href="viewForum.htm" class="menuLink">View Forum</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="viewAllBets" href="viewAllBets.htm" class="menuLink">View All Bets</a>
			</td>
		</tr>
	</table>
</div>
