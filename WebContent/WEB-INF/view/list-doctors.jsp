<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>List Doctors</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Doctor Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new Doctor -->
			<input type="button" value="Add Doctor" class="add-button"
				   onclick="window.location.href='showFormToAddDoctor'; return false;"
			/>
			
			<!--  add a search box -->
			<form:form action="searchDoctorsByDoctorId" method="GET">
				Clinic Id: <input type="text" name="clinicId" />	
				<input type="submit" value="Search Doctor" class="add-button" />
			</form:form>
			
			<!--  add a search box -->
			<form:form action="searchDoctorsByClinicId" method="GET">
				Clinic Id: <input type="text" name="clinicId" />	
				<input type="submit" value="Search Doctor" class="add-button" />
			</form:form>
			
			<!-- html table here -->
			<table>
			<tr>
				<th>Doctor Name</th>
				<th>Clinic Id</th>
				<th>Phone</th>
				<th>Bio</th>
				
				<th>Action</th>
			</tr>
			
			<!-- loap over and print Doctors -->
			<c:forEach var="tempDoctor" items="${doctors}">
			
				<!-- Create an update and delete Links with Doctor id -->
				<c:url var="updateLink" value="/doctor/showFormToUpdate">
					<c:param name="doctorId" value="${tempDoctor.doctorId}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/doctor/deleteDoctor">
					<c:param name="doctorId" value="${tempDoctor.doctorId}"/>
				</c:url>
				
				<tr>
					<td>${tempDoctor.doctorName} </td>
					<td>${tempDoctor.clinic} </td>
					<td>${tempDoctor.phone} </td>
					<td>${tempDoctor.bio} </td>
					<td> <a href="${updateLink}" >Update</a>
					| 
					<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete Doctor ${tempDoctor.doctorName} ?'))) return false" >
					Delete</a> </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>