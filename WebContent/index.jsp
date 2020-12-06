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
		<h2> Vet Clinic System </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<h4> List Clinics Link : http://localhost:8080/vet-clinic-system/clinic/list </h4>
			<h4> List Doctors Link : http://localhost:8080/vet-clinic-system/doctor/list </h4>
			<h4> List Owners Link : http://localhost:8080/vet-clinic-system/owner/list </h4>
			<h4> List Pets Link : http://localhost:8080/vet-clinic-system/pet/list </h4>
			<h4> List Visits Link : http://localhost:8080/vet-clinic-system/visit/list </h4>
		</div>
	</div>
	

	
</body>
	
 <!--  % response.sendRedirect("customer/list");% --> 