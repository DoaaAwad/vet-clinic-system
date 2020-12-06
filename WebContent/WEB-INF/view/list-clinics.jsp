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
<title>List Clinics</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Clinic Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new Clinic -->
			<input type="button" value="Add Clinic" class="add-button"
				   onclick="window.location.href='showFormToAddClinic'; return false;"
			/>
			<!--  add a search box -->
			<form:form action="searchClinicsByClinicId" method="GET">
				Clinic Id: <input type="text" name="clinicId" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  add a search box -->
			<form:form action="searchClinicsByPhone" method="GET">
				Phone: <input type="text" name="phone" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  add a search box -->
			<form:form action="searchClinicsByAddress" method="GET">
				Address: <input type="text" name="address" />	
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- html table here -->
			<table>
			<tr>
				<th>Clinic Name</th>
				<th>Working Days And Hours</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Social Network URLs</th>
				
				<th>Action</th>
			</tr>
			
			<!-- loap over and print Clinics -->
			<c:forEach var="tempClinic" items="${clinics}">
			
				<!-- Create an update and delete Links with Clinic id -->
				<c:url var="updateLink" value="/Clinic/showFormToUpdate">
					<c:param name="clinicId" value="${tempClinic.clinicId}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/Clinic/deleteClinic">
					<c:param name="clinicId" value="${tempClinic.clinicId}"/>
				</c:url>
				
				<tr>
					<td>${tempClinic.clinicName} </td>
					<td>${tempClinic.workingDaysAndHours} </td>
					<td>${tempClinic.phone} </td>
					<td>${tempClinic.email} </td>
					<td>${tempClinic.address} </td>
					<td>${tempClinic.socialNetworkURLs} </td>
					
					<td> <a href="${updateLink}" >Update</a>
					| 
					<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete Clinic ${tempClinic.clinicName} ?'))) return false" >
					Delete</a> </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>