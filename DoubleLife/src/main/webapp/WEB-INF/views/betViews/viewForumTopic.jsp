<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Forum</title>
</head>
<body>
<div class="body_header">
	Forum Topic: ${forumTopic.topicName}
</div>
<div class="regular_table">
	<table>
		<thead>
			<tr>
				<th>User</th><th>Post</th><th>Date</th>
			</tr>
		</thead>
  		<c:forEach items="${entries}" var="thisEntry">
			<tr>
				<td>
				${thisEntry.userName}
				</td>
				<td>
					${thisEntry.forumPost}
				</td>
				<td>
					${thisEntry.dateTime}
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="viewForumTopic.htm" method="post">
		<input name="topicId" id="topicId" type="hidden" value="${forumTopic.id}" />
		<table align="center">
			<tr>
				<td>
					<textarea name="forumPost" id="forumPost" cols="80" rows="8">Enter your comments here...</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input id="sbmtPost" type="submit" value="Add Post">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
