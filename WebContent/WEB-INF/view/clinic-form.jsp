<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Clinic Form</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css"/>


</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Clinic Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Clinic</h3>
		
		<form:form action="saveClinic" modelAttribute="Clinic" method="POST">
			<!-- need to associate data with Clinic id  -->
			<form:hidden path="ClinicId"/>
		
			<table>
				<tbody>
					<tr>
					<td><label>Clinic Name: </label></td>
					<td> <form:input path="ClinicName"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Working Days And Hours: </label></td>
					<td> <form:input path="workingDaysAndHours" required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Phone: </label></td>
					<td> <form:input path="phone"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Email: </label></td>
					<td> <form:input path="email"  required = "true" /> </td>
					<!-- pattern = "" -->
					</tr>
					
					<tr>
					<td><label>Address: </label></td>
					<td> <form:input path="address"  required = "true"/> </td>
					</tr>
					
					<tr>
					<td><label>Social Network URLs: </label></td>
					<td> <form:input path="socialNetworkURLs" /> </td>
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
		
		<br><br>
		
	</div>
	
	
</body>
</html>