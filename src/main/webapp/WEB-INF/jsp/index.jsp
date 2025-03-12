<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>名前</th>
			<th>性別</th>
			<th>年齢</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userName }</td>
				<td>${user.userSex }</td>
				<td>${user.address}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>