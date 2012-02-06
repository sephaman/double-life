<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<link rel="stylesheet" href="<c:url value="/resources/css/doublelife.css"/>" type="text/css"/>
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="top-menu" />
		<table width="100%" border="0">
			<tr>
				<td width="20%" align="left" valign="top">
					<tiles:insertAttribute name="left-menu" />
				</td>
				<td align="left" valign="top">
					<tiles:insertAttribute name="info-bar"/>
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
		</table>
		<tiles:insertAttribute name="footer" />
	</body>
</html>