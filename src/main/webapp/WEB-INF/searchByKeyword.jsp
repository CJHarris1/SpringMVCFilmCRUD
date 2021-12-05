<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${! empty films}">
		
		<c:forEach items="${films}" var="film">
			Film ID: <c:out value="${film.id}" />
			<br>
     Title: <c:out value="${film.title}" />
			<br>
     Description: <c:out value="${film.description}" />
			<br>
     Release Year: <c:out value="${film.releaseYear}" />
			<br>
     Language: <c:out value="${film.languageName}" />
			<br>
     Rating: <c:out value="${film.rating}" />
			<br>
     Actors:<br> <c:forEach items="${ film.actors}" var="actor">
				${actor.firstName} ${actor.lastName}
				<br>
			</c:forEach>
			<br>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Invalid keyword</p>
		</c:otherwise>
	</c:choose>

	<p>
		<a href="home.do">HOME</a>
	</p>
</body>
</html>