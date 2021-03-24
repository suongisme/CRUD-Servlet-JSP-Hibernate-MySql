<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value=" ${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="${ context }/css/Menu.css">
</head>
<body>
	<div class="menu">
		<a class="menu__link" href="${ context }/profile"> Profile </a>
		<a class="menu__link" href="${ context }/products"> Product </a>
		<a class="menu__link" href="${ context }/users"> User </a>
		<a class="menu__link" href="${ context }/logout"> Logout </a>
	</div>
</body>
</html>