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
			<td align="left">
				<img src="<c:url value="/resources/img/tipntradeHeader.jpg"/>" alt="header logo" style="width:20%"/>
			</td>
			<td align="right" class="screenModeSubTitle">
				Current User: ${username_head} Role:${rolename}
			</td>
		</tr>
	</table>
</div>
