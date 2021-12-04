<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Find movie by ID</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty ID}">
     Title: <c:out value="${ID.title}" />
			<br>
     Description: <c:out value="${ID.description}" />
			<br>
     Release Year: <c:out value="${ID.releaseYear}" />
			<br>
     Language: <c:out value="${ID.languageName}" />
			<br>
     Rating: <c:out value="${ID.rating}" />
			<br>
     Actors: <c:forEach items="${ ID.actors}" var="actor">
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