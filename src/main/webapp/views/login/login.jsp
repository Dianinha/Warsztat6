<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form:form action="login" method="post">
    <div>
      Login: <input type="text" name="username"/>
    </div>
    <div>
      Password: <input type="password" name="password"/>
    </div>
    <div>
      <input type="submit" value="Log in"/>
    </div>
    <div>
      You don't have an account? <a href=<c:url value="/user/register"/>> Register</a>
    </div>  
    <c:if test="${not empty message }">
	<c:out value="${message}"></c:out>    
</c:if>
</form:form>
</body>
</html>