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
<title>List Visits</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Visit Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new Visit -->
			<input type="button" value="Add Visit" class="add-button"
				   onclick="window.location.href='showFormToAddVisit'; return false;"
			/>
			
			<!--  add a search box -->
			<form:form action="searchByVisitId" method="GET">
				Visit Id: <input type="text" name="VisitId" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- html table here -->
			<table>
			<tr>
				<th>Doctor Name</th>
				<th>Clinic Name</th>
				<th>Pet Name</th>
				<th>visitDate</th>
				
				<th>Action</th>
			</tr>
			
			<!-- loap over and print Visits -->
			<c:forEach var="tempVisit" items="${visits}">
			
				<!-- Create an update and delete Links with Visit id -->
				<c:url var="updateLink" value="/visit/showFormToUpdate">
					<c:param name="visitId" value="${tempVisit.visitId}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/Visit/deleteVisit">
					<c:param name="visitId" value="${tempVisit.visitId}"/>
				</c:url>
				
				<tr>
					<td>${tempVisit.doctor.doctorName} </td>
					<td>${tempVisit.clinic.clinicName} </td>
					<td>${tempVisit.pet.petName} </td>
					<td>${tempVisit.visitDate} </td>
					
					<td> <a href="${updateLink}" >Update</a>
					
					<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete Visit ${tempVisit.visitName} ?'))) return false" >
					Delete</a> </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>