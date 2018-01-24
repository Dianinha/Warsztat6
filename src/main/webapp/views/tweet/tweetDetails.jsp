<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweet details</title>
</head>
<body>
	Title:
	<c:out value="${tweet.title }"></c:out>
	<br> Content:
	<c:out value="${tweet.text }"></c:out>
	<br> Created:
	<c:out value="${tweet.created }"></c:out>
	<br> Author:
	<c:out value="${tweet.user.username }"></c:out>
	<br> Comments:
	<c:forEach items="${comments}" var="com">
Text:<c:out value="${com.text }"></c:out>
		<br>
Author: <c:out value="${com.user.username }"></c:out>
		<br>
Created: <c:out value="${com.created }"></c:out>
		<br>
		<br>
	</c:forEach>

	

	<c:if test="${not empty loggedUser }">
	Add new comment:
	<form:form  method="post" modelAttribute="comment">
			<div>
				Text:
				<form:input path="text" />
			</div>
			<div>
				<input type="submit" value="Tweet it to the world" />
			</div>
		</form:form>
	</c:if>
	<br>
</body>
</html>