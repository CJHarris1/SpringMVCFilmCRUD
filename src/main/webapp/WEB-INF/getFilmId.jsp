<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Find movie by ID</title>
</head>
<body>
<c:choose>
   <c:when test="${! empty ID}">
     <c:out value="${ID.title}"/><br>
     <c:out value="${ID.description}"/><br>
     <c:out value="${ID.releaseYear}"/><br>
     <c:out value="${ID.languageName}"/><br>
     <c:out value="${ID.rating}"/><br>
     <c:out value="${ID.actors}"/><br>
   </c:when>
   <c:otherwise>
     <p>Invalid id</p>
   </c:otherwise>
 </c:choose>
 
</body>
</html>