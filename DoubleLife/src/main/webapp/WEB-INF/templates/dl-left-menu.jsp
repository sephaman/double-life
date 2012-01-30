<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Properties" %>
<div id="header" class="menuHeader">
	<table width="100%" border="0">
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="stockPortFolioLink" href="userStockPortfolio.htm" class="menuLink">View Portfolio</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
				<a id="stockSearchLink" href="stockSearch.htm" class="menuLink">Search For Stock</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="joinCompLink" href="dlCompsView.htm" class="menuLink">Join Competition</a>
			</td>
		</tr>
		<tr>
			<td valign="middle" style="font-size: normal" class="button">
					<a id="createCompLink" href="dlCompsCreate.htm" class="menuLink">Create Competition</a>
			</td>
		</tr>
	</table>
</div>
