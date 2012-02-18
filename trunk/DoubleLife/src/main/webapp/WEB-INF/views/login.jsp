<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<link rel="stylesheet" href="<c:url value="/resources/css/doublelife.css"/>" type="text/css"/>
		<meta http-equiv="version" content="$Id: header.jsp, v1.0 2010/07/30 $" />
		<title>Tip n' Trade Login</title>
	</head>
	<body>
		
		<div id="loginPanel" class="login_panels">
			<img src="<c:url value="/resources/img/tipntradeHeader2.jpg"/>" alt="header logo" width="170" height="70" alt="tipNtrade"/>
			<p/>
			<h3>Life Simulating Financial Games</h3>
			<div class="errorMessage" style="color:#FFE09D;font-size:1.1em;">
                <c:if test="${!empty param.login_error}">
                    Login failed.  Please retry.
                </c:if>

            </div>
			<div id="loginInnerPanel">
				<form id="frmLogin" action="<c:url value="j_spring_security_check"/>" method="post">
					<table width="70%" border="0">
						<tr>
							<td class="loginLabel">Username</td>
							<td class="loginInput">
								<input id="txtUserName" class="loginInput" name="j_username" type="text" alt="username" tabindex="1" />
							</td>
						</tr>
						<tr>
							<td class="loginLabel">Password</td>
							<td class="loginInput">
								<input id="txtPassword" name="j_password" class="loginInput" type="password" alt="password" tabindex="2""/>
							</td>
						</tr>
						<tr>
							<td align="middle">
								<input id="btnSubmit" class="button" type="submit" value="Login" tabindex="3" />
							</td>
						</tr>
					</table>
				</form>
			</div>
				<a id="registerLink" href="userRegistration.htm">Register</a> &nbsp;&nbsp;<a id="forgotLink" href="forgotPassword.htm">Forgot Password?</a>
			<p/>
			<div>
			</div>
			
		</div>
	</body>
</html>