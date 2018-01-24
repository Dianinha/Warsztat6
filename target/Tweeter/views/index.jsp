<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
	Homepage
	<br> I already have an account:
	<a href=<c:url value="/user/login"/>> Click here!</a>

	<br> I want to register:
	<a href=<c:url value="user/register"/>> Click here!</a>

	<br>

	<c:forEach items="${tweets}" var="tweet1">
Title:<c:out value="${tweet1.title }"></c:out>
		<br>
Content: <c:out value="${tweet1.text }"></c:out>
		<br>
Created: <c:out value="${tweet1.created }"></c:out>
		<br>
Author: <c:out value="${tweet1.user.username }"></c:out>
		<br>
		<a href=<c:url value="tweet/${tweet1.id}"/>> Show details</a>
		<br>
		<br>

	</c:forEach>
	<c:if test="${not empty loggedUser }">
	Tweet something:
	<form:form action="newTweet" method="post" modelAttribute="tweet">
			<div>
				Title:
				<form:input path="title" />
			</div>
			<div>
				Content:
				<form:input path="text" />
			</div>
			<div>
				<input type="submit" value="Tweet it to the world" />
			</div>

		</form:form>
	</c:if>
</body>
</html>