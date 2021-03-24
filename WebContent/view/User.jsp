<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="${ context }/css/Product.css">
</head>
<body>
<jsp:include page="/view/Menu.jsp"/>
	<div class="body">
		<form class="body__form" action="users" method="POST">
			<input type="text" name="username" placeholder="Username">
			<input type="text" name="password" placeholder="Password">
			<input type="submit" value="SUBMIT">
			<input type="reset" value="CLEAR FORM">
		</form>
		
		<table class="body__list">
			<thead>
				<tr>
					<th>USERNAME</th>
					<th>PASSWORD</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="list" items="${ users }">
					<tr class="row">
						<td>${ list.getUsername() }</td>
						<td>${ list.getPassword() }</td>
						<td> <a class="row__handle" href="${ context }/users/${list.getUsername()}?delete=true">DELETE</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="${ context }/js/Product.js"></script>
</body>
</html>