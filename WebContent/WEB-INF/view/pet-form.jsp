<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Pet Form</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css"/>


</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Pet Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Pet</h3>
		
		<form:form action="savePet" modelAttribute="pet" method="POST">
			<!-- need to associate data with pet id  -->
			<form:hidden path="petId"/>
		
			<table>
				<tbody>
					<tr>
					<td><label>Pet Name: </label></td>
					<td> <form:input path="petName"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Owner Id: </label></td>
					<td> <form:input path="owner" /> </td>
					</tr>
					
					<tr>
					<td><label>Gender: </label></td>
					<td> <form:input path="gender"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Date of birth: </label></td>
					
					<td> <form:input type="date" id="birthDate" path="birthDate"/> </td>
					</tr>
					
					<tr>
					<td><label>Animal Kind: </label></td>
					<td> <form:input path="animalKind"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Animal Weight: </label></td>
					<td> <form:input path="weight"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Photo 1 URL: </label></td>
					<td> <form:input path="photoURL1" /> </td>
					</tr>
					
					<tr>
					<td><label>Photo 2 URL: </label></td>
					<td> <form:input path="photoURL2" /> </td>
					</tr>
					
					<tr>
					<td><label>Photo 3 URL: </label></td>
					<td> <form:input path="photoURL3" /> </td>
					</tr>
					
					<tr>
					<td><label></label></td>
					<td> <input type="button" value="Cancel" class="save" onclick="window.location.href='list'; return false;"/> </td>
					<td> <input type="submit" value="Save" class="save"/> </td>
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
		
		<br><br>
		
	</div>
	
	
</body>
</html>