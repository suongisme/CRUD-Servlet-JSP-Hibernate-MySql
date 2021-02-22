<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.body {
		width: 80%;
	    text-align: center;
	    height: 300px;
	    border: 1px solid #dad7d7;
	    margin: auto;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	}
	
	span  {
		font-size: 3rem;
	}
	
	a {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
	<jsp:include page="/view/Menu.jsp"/>
	<div class="body">
		<span>
			You have successfully logged out.
			<a href="login">login</a> here
		</span>
	</div>
</body>
</html>