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
<title>List Owners</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Owner Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new Owner -->
			<input type="button" value="Add Owner" class="add-button"
				   onclick="window.location.href='showFormToAddOwner'; return false;"
			/>
			
			<!--  add a search box -->
			<form:form action="searchByOwnerId" method="GET">
				Owner Id: <input type="text" name="ownerId" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- html table here -->
			<table>
			<tr>
				<th>Owner Name</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Address</th>
				
				<th>Action</th>
			</tr>
			
			<!-- loap over and print Owners -->
			<c:forEach var="tempOwner" items="${owners}">
			
				<!-- Create an update and delete Links with Owner id -->
				<c:url var="updateLink" value="/owner/showFormToUpdate">
					<c:param name="ownerId" value="${tempOwner.ownerId}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/Owner/deleteOwner">
					<c:param name="ownerId" value="${tempOwner.ownerId}"/>
				</c:url>
				
				<tr>
					<td>${tempOwner.ownerName} </td>
					<td>${tempOwner.gender} </td>
					<td>${tempOwner.email} </td>
					<td>${tempOwner.phone} </td>
					<td>${tempOwner.address} </td>
					
					<td> <a href="${updateLink}" >Update</a>
					
					<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete Owner ${tempOwner.ownerName} ?'))) return false" >
					Delete</a> </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>