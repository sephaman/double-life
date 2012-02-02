<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header" class="menuHeader">
	<c:if test="${menuType eq 'bet'}">
		<c:if test="${rolename == 'ROLE_ADMIN'}">
			<jsp:include page="bet-left-menu.jsp"></jsp:include>
		</c:if>
		<c:if test="${rolename == 'ROLE_USER'}">
			<jsp:include page="bet-left-menu-user.jsp"></jsp:include>
		</c:if>
	</c:if>
	<c:if test="${menuType eq 'dl'}">
		<jsp:include page="dl-left-menu.jsp"></jsp:include>
	</c:if>
</div>
