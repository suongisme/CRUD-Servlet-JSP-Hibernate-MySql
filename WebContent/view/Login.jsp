<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="StyleSheet" href="${ context }/css/Login.css">
</head>
<body>
	<h1>Login</h1>
	<div class="login">
		<h3 class="login__state">
			${ stateLogin }
		</h3>
		<form action="${ context }/login" method="POST">
			<div class="login__username">
				<label>Username</label>
				<input type="text" name="username" placeholder="username"/>
			</div>
			<div class="login__password">
				<label>Password</label>
				<input type="password" name="password" placeholder="password"/>
			</div>
			<div class="login__btn">
				<input class="btn--green" type="submit" value="login">
			</div>
		</form>
	</div>
</body>
</html>