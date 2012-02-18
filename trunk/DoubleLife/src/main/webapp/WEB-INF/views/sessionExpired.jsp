<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Properties" %>
<%
Properties props = new Properties();
props.load(pageContext.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
%>
<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="version" content="$Id: header.jsp, v1.0 2010/07/30 $" />
		<link rel="stylesheet" href="<c:url value="/resources/css/doublelife.css"/>" type="text/css"/>
		<title>Session Expired</title>
	</head>
	<body>
		<div id="loginPanel">
			<img src="<c:url value="/resources/img/tipntradeHeader2.jpg"/>" alt="header logo" width="140" height="50" alt="tipNtrade"/>
			<p/>
			<h4>Session Expired</h4>
			<p/>
			<div id="loginInnerPanel">
				Your session has expired due to inactivity, or because another session
				has been started elsewhere using your login details, so you have been
				logged out of the current session.
				<p/>
				<a class="button" href="<c:url value="/login.form"/>">Login Again</a>
				<p/>
			</div>
			<p/>
			<div>
			<b><%= (new SimpleDateFormat("EEEE, dd MMMMM yyyy")).format(new Date()) %></b>
			</div>
		</div>
	</body>
</html>