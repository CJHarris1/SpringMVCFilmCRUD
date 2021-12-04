<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find movie by ID</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty Id}">
	 Film ID: <c:out value="${createID.id}" />
			<br>
     Title: <c:out value="${Id.title}" />
			<br>
     Description: <c:out value="${Id.description}" />
			<br>
     Release Year: <c:out value="${Id.releaseYear}" />
			<br>
     Language: <c:out value="${Id.languageName}" />
			<br>
     Rating: <c:out value="${Id.rating}" />
			<br>
     Actors: <c:forEach items="${ Id.actors}" var="actor">
				<p>${actor.firstName }${actor.lastName }</p>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Invalid id</p>
		</c:otherwise>
	</c:choose>

	<p>
		<a href="home.do">HOME</a>
	</p>
</body>
</html>