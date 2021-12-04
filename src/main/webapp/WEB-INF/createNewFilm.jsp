<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Film</title>
</head>
<body>
	<h1>Film you created</h1><br>
	<c:choose>
		<c:when test="${! empty createID}">
	 Film ID: <c:out value="${createID.id}" />
			<br>
     Title: <c:out value="${createID.title}" />
			<br>
     Description: <c:out value="${createID.description}" />
			<br>
     Release Year: <c:out value="${createID.releaseYear}" />
			<br>
     Language: <c:out value="${createID.languageName}" />
			<br>
     Rating: <c:out value="${createID.rating}" />
			<br>
     Actors: <br><c:forEach items="${ createID.actors}" var="actor">
				${actor.firstName } ${actor.lastName }
				<br>
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