<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="header" class="menuHeader">
	<table width="100%" border="0">
		<!-- title -->
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
				<a id="dblLifeHomeLink" href="doubleLifeHome.htm" class="menuLink">Double Life</a>
			</td>
			<td valign="middle" style="font-size: normal" class="button">
				<a id="fantasyBetHomeLink" href="fantasyBetHome.htm" class="menuLink">Fantasy Betting</a>
			</td>
			<td valign="middle" style="font-size: normal" class="button">
				<a href="<c:url value="/j_spring_security_logout"/>" class="menuLink">Logout</a>
			</td>
		</tr>
	</table>
</div>
