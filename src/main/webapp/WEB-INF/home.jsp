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
<h3>Search Film with id<h3>
  <form action="GetFilmId.do" method="GET">
 	ID:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 </form>
 
 
 
 
 <h3>Create a new film</h3>
 <form action="createNewFilm.do" method="POST">
 	Name:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 	<br>
 	
 	Description:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 	<br>
 	
 	Release Year:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 	<br>
 	
 	Rating:
 	<input type="text" name="ID"/>
 	<input type="submit" value="Find film" />
 	<br>
 	
 	Language:
 	<input type="checkbox" id="vehicle1" name="language1" value="Bike">
	<label for="language1"> I have a bike</label><br>
	<input type="checkbox" id="vehicle2" name="language2" value="Car">
	<label for="vehicle2"> I have a car</label><br>
	<input type="checkbox" id="vehicle3" name="language3" value="Boat">
	<label for="vehicle3"> I have a boat</label><br>
 	
 	
 </form>
 	
 
</body>
</html>