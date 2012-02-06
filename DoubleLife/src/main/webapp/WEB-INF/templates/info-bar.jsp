<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="header" class="infoBar">
	<table width="100%" border="0">
		<!-- info bar -->
		<c:if test="${not empty username_head}">
			<c:if test="${not empty betComp}">
					<c:if test="${menuType eq 'bet'}">
					<tr>
						<td valign="middle" style="font-size: normal">
							Competition: &nbsp; ${betComp.name}
						</td>
						<td valign="middle" style="font-size: normal" align="right">
							Pending Bets: &nbsp; ${pendingBets_head}
						</td>
						<td valign="middle" style="font-size: normal" align="right">
							Amount Available: &nbsp; $${userAccount_head}
						</td>
					</tr>
				</c:if>
			</c:if>
		</c:if>
	</table>
</div>
