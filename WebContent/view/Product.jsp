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
		<form class="body__form" action="products" method="POST">
			<input type="text" name="ID" placeholder="ID (only update or delete)" readonly>
			<input type="text" name="Name" placeholder="Name">
			<input type="number" name="Price" placeholder="Price">
			<input type="text" name="Description" placeholder="Description">
			<input type="submit" value="SUBMIT">
			<input type="reset" value="CLEAR FORM">
		</form>
		
		<table class="body__list">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PRICE</th>
					<th>DESC</th>
					<th>ACTION</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="list" items="${ products }">
					<tr class="row">
						<td>${ list.getId() }</td>
						<td>${ list.getName() }</td>
						<td>${ list.getPrice() }</td>
						<td>${ list.getDesc() }</td>
						<td> <a class="row__handle" href="${ context }/products/${list.getId()}?delete=true">DELETE</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="${ context }/js/Product.js"></script>
</body>
</html>