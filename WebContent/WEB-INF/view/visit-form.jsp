<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Owner Form</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css"/>


</head>
<body>

<div id="wrapper">
		<div id="header">
		<h2> Owner Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Owner</h3>
		
		<form:form action="saveOwner" modelAttribute="owner" method="POST">
			<!-- need to associate data with Owner id  -->
			<form:hidden path="ownerId"/>
		
			<table>
				<tbody>
					<tr>
					<td><label>Doctor: </label></td>
					<td> <form:input path="ownerName" /> </td>
					</tr>
					
					<tr>
					<td><label>Clinic: </label></td>
					<td> <form:input path="gender" /> </td>
					</tr>
					
					<tr>
					<td><label>Pet: </label></td>
					<td> <form:input path="email" /> </td>
					</tr>
					
					<tr>
					<td><label>Date: </label></td>
					<td> <form:input path="phone" /> </td>
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