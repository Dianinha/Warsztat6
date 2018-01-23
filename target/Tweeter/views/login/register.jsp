<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register here:</title>
<style type="text/css">
.error {
	background-color: red;
	color: white;
}
</style>
</head>
<body>
	<form:form action="register" method="post" modelAttribute="user">
		<div>
			Login:
			<form:input path="username" />
			<form:errors path="username" cssClass="error" />
		</div>
		<div>
			Password:
			<form:password path="password" />
			<form:errors path="password" cssClass="error" />
		</div>
		<div>
			E-mail:
			<form:input type="email" path="email" />
			<form:errors path="email" cssClass="error" />
		</div>
		<div>
			<input type="submit" value="Register" />
		</div>
	</form:form>
</body>
</html>