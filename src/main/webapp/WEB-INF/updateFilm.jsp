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
     Edit description: <input type="text" name="description"/>
			<br>
     Release Year: <c:out value="${Id.releaseYear}" />
     Edit release year: <input type="text" name="releaseYear"/>
			<br>
     Language: <c:out value="${Id.languageName}" />
     Edit language:
 	<input type="radio" id="language1" name="languageId" value="English">
 	<label for="language1">English</label>
	<input type="radio" id="language2" name="languageId" value="Italian">
	<label for="language2">Italian</label>
	<input type="radio" id="language3" name="languageId" value="Japanese">
	<label for="language3">Japanese</label>
	<input type="radio" id="language4" name="languageId" value="Mandarin">
	<label for="language4">Mandarin</label>
	<input type="radio" id="language5" name="languageId" value="French">
	<label for="language5">French</label>
	<input type="radio" id="language6" name="languageId" value="German">
	<label for="language6">German</label>
			<br>
     Rating: <c:out value="${Id.rating}" />
     Edit rating: <input type="radio" id="G" name="rating" value="G">
 	<label for="G">G</label>
	<input type="radio" id="PG" name="rating" value="PG">
	<label for="PG">PG</label>
	<input type="radio" id="PG13" name="rating" value="PG13">
	<label for="PG13">PG13</label>
	<input type="radio" id="R" name="rating" value="R">
	<label for="R">R</label>
	<input type="radio" id="NC17" name="rating" value="NC17">
	<label for="NC17">NC17</label>
			<br>
    
    
    
    
	<input type="submit" name= "update film" value="Update film" />
	<input type="hidden" name= "film" value="${Id}" />
	<br>
    
    
    
    
    
    
		</c:when>
		<c:otherwise>
			<p>Invalid id</p>
		</c:otherwise>
	</c:choose>
</form>
</body>
</html>