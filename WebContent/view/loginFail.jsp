<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> LoginFail Page </title>
</head>
<body>
	<h1>Login Failed: ${id} is not present </h1>
	<p><a href="/helloMVC/index.jsp">go to home page</a></p>
	<p><a href="/helloMVC/view/loginForm.jsp"> try again login </a></p>
	<p><a href="/helloMVC/view/registerForm.jsp"> regist now </a></p>
</body>
</html>