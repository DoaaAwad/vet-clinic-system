<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Doctor Form</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css"/>


</head>
<body>

<div id="wrapper">
		<div id="header">
		<h2> Doctor Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Doctor</h3>
		
		<form:form action="saveDoctor" modelAttribute="doctor" method="POST">
			<!-- need to associate data with Doctor id  -->
			<form:hidden path="doctorId"/>
		
			<table>
				<tbody>
					<tr>
					<td><label>Doctor Name: </label></td>
					<td> <form:input path="doctorName" /> </td>
					</tr>
					
					<tr>
					<td><label>Clinic Id: </label></td>
					<td> <!--form:input path="clinic" /--> 
						<select name="clinic">
						    <c:forEach items="${clinicsList}" var="clinic">
						        <option value="${clinic}">${clinic.clinicName}</option>
						    </c:forEach>
						</select>
					</td>
					</tr>
					
					<tr>
					<td><label>Phone: </label></td>
					<td> <form:input path="phone" /> </td>
					</tr>
					
					<tr>
					<td><label>Photo Url: </label></td>
					<td> <form:input path="photoUrl" /> </td>
					</tr>
					
					<tr>
					<td><label>Bio: </label></td>
					<td> <form:input path="bio" /> </td>
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