<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Forum</title>
</head>
<body>
<div class="body_header">
	 Tip n' Trade Forum
</div>
<div class="regular_table">
	<table>
		<tr>
			<td>
				Topics
			</td>
		</tr>
	  		<c:forEach items="${topics}" var="thisTopic">
				<tr>
					<td>
						<a id="topic-${thisTopic.id}" href="viewForumTopic.htm?topicId=${thisTopic.id}">${thisTopic.topicName}</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>
					Create Topic:
				</td>
				<td>
					<input id="newTopic" name="newTopic"/>
				</td>
			</tr>
			<tr>
				<td>
						<input type="submit" name="addTopic" id="addTopicBtn" value="Add New Topic"/>
				</td>
			</tr>
	</table>
</div>
</body>
</html>
