<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
</head>
<body>
<h1>Films R Us!</h1>
<br>
<h3>Search Film with id<h3>
  <form action="GetFilmId.do" method="GET">
 	ID:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 </form>
 <br><br><br>
 
 
 
 <h3>Create a new film</h3>
 <form action="createNewFilm.do" method="POST">
 	Name:
 	<input type="text" name="ID"/>
 	<br>
 	
 	Description:
 	<input type="text" name="ID"/>
 	<br>
 	
 	Release Year:
 	<input type="text" name="ID"/>
 	<br>
 	
 	Rating:
 	<input type="text" name="ID"/>
 	<br>
 	
 	Language:
 	<input type="radio" id="language1" name="language" value="English">
 	<label for="language1">English</label>
	<input type="radio" id="language2" name="language" value="Italian">
	<label for="language2">Italian</label>
	<input type="radio" id="language3" name="language" value="Japanese">
	<label for="language3">Japanese</label>
	<input type="radio" id="language4" name="language" value="Mandarin">
	<label for="language4">Mandarin</label>
	<input type="radio" id="language5" name="language" value="French">
	<label for="language5">French</label>
	<input type="radio" id="language6" name="language" value="German">
	<label for="language6">German</label>
 	<br>
 	<input type="submit" value="Create Film" />
 </form>
 	
 
</body>
</html>