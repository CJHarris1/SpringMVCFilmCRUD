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
</body>
</html>