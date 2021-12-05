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
	 Film ID: <c:out value="${Id.id}" />
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
	 Category: <c:out value="${Id.category}"  />
	 		<br>
     Actors: <br><c:forEach items="${ Id.actors}" var="actor">
				${actor.firstName } ${actor.lastName }
				<br>
			</c:forEach>
			<br><br>
	
	<form action="updateMenu.do" method="POST">
	<input type="submit" name= "update film" value="Update film" />
	<input type="hidden" name= "film" value="${Id.id}" />
	</form>
		
	<br>
	<form action="delete.do" method="POST">
	<input type="submit" name= "delete film" value="Delete film" />
	<input type="hidden" name= "film" value="${Id.id}" />
	</form>
		</c:when>
		<c:otherwise>
			<p>Invalid id</p>
		</c:otherwise>
	</c:choose>

	
	
	<br>
		<a href="home.do">HOME</a>
	
	
	
</body>
</html>