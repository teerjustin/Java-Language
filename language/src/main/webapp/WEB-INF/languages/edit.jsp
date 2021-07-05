<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Edit Language</h1>
	<a href = "<c:url value = "/language/${language.id}/delete"/>">  Delete </a>
	<form:form action="/language/${language.id}/edit" method="post" modelAttribute="language">
		<label for="name">Language Name:</label>
		<input type="text" id="name" name="name">
		
		<label for="creator">Your Name:</label>
		<input type="text" id="creator" name="creator">
		
		<label for="version">Version: </label>
		<input type="text" id="version" name="version">
		<input type="submit">
	</form:form>   

</body>
</html>