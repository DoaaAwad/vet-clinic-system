<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<!--meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<title>List Pets</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Pet Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new Pet -->
			<input type="button" value="Add Pet" class="add-button"
				   onclick="window.location.href='showFormForAdd'; return false;"
			/>
			
			<!--  add a search box -->
			<form:form action="searchPetsByPetId" method="GET">
				Pet Id: <input type="text" name="ownerId" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  add a search box -->
			<form:form action="searchPetsByOwnerId" method="GET">
				Owner Id: <input type="text" name="ownerId" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- html table here -->
			<table>
			<tr>
				<th>Pet Name</th>
				<th>Owner Id</th>
				<th>Gender</th>
				<th>Date Of Birth</th>
				<th>Animal Kind</th>
				<th>Weight</th>
				
				<th>Action</th>
			</tr>
			
			<!-- loap over and print Pets -->
			<c:forEach var="tempPet" items="${Pets}">
			
				<!-- Create an update and delete Links with Pet id -->
				<c:url var="updateLink" value="/Pet/showFormToUpdate">
					<c:param name="PetId" value="${tempPet.PetId}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/Pet/deletePet">
					<c:param name="PetId" value="${tempPet.PetId}"/>
				</c:url>
				
				<tr>
					<td>${tempPet.petName} </td>
					<td>${tempPet.owner} </td>
					<td>${tempPet.gender} </td>
					<td>${tempPet.birthDate} </td>
					<td>${tempPet.animalKind} </td>
					<td>${tempPet.weight} </td>
					
					<td> <a href="${updateLink}" >Update</a>
					| 
					<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete Pet ${tempPet.petName} ?'))) return false" >
					Delete</a> </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>