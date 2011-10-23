<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="header">
	<table width="100%" border="0">
		<!-- title -->
		<tr>
			<td valign="middle" style="font-size: normal">
				<a id="dblLifeHomeLink" href="doubleLifeHome.htm">Double Life</a>
			</td>
			<td valign="middle" style="font-size: normal">
				<a id="fantasyBetHomeLink" href="fantasyBetHome.htm">Fantasy Betting</a>
			</td>
			<td valign="middle" style="font-size: normal">
				<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</td>
		</tr>
	</table>
</div>
