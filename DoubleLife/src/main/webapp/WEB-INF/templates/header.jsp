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
			<td align="left" valign="middle">
				<img src="<c:url value="/resources/img/tipntradeHeader2.jpg"/>" alt="header logo" width="180" height="70" alt="tipNtrade"/>
			</td>
			<td align="right" valign="bottom" class="screenModeSubTitle" style="color:#990000">
				Current User: ${username_head}
			</td>
		</tr>
	</table>
</div>
