<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> HELLO HELLO</h1>
	
		<h1>All Languages</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Language</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td> <c:out value="${language.name}"></c:out> </td>
		            <td> <c:out value="${language.creator}"></c:out></td>
		            <td> <c:out value="${language.version}"></c:out></td>
		            <td><a href = "<c:url value = "/language/${language.id}/edit"/>"> Edit </a></td>	
		            <td><a href = "<c:url value = "/language/${language.id}/delete"/>"> Delete </a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>


	<h1>New Language</h1>
	<form:form action="/language/create" method="post" modelAttribute="language">
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