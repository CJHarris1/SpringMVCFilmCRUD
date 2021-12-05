<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<body>
<form action="updateFilm.do" method="POST">
<c:choose>
		<c:when test="${! empty Id}">
	 Film ID: <c:out value="${Id.id}" />
			<br>
     Title: <c:out value="${Id.title}" />
     Edit title: <input type="text" name="title"/>
			<br>
     Description: <c:out value="${Id.description}" />
     Edit description: <input type="text" name="releaseYear"/>
			<br>
     Release Year: <c:out value="${Id.releaseYear}" />
     Edit release year: <input type="text" name="releaseYear"/>
			<br>
     Language: <c:out value="${Id.languageName}" />
     Edit language<input type="text" name="releaseYear"/>
			<br>
     Rating: <c:out value="${Id.rating}" />
     Edit rating: <input type="text" name="releaseYear"/>
			<br>
    
		</c:when>
		<c:otherwise>
			<p>Invalid id</p>
		</c:otherwise>
	</c:choose>
</form>
</body>
</html>