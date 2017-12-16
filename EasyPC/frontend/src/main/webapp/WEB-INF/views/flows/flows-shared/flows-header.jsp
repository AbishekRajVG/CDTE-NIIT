<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>






<!-- css -->
<spring:url var="css" value="/resources/css" />


<!-- js -->
<spring:url var="js" value="/resources/js" />


<!-- images -->
<spring:url var="images" value="/resources/images" />



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<html lang="en">

<head>
<style>
.bg-yellow {
	background-color: #E9E935;
}
</style>

<style>
.bg-lightyellow {
	background-color: #FFFFAA;
}
</style>
<style>
.bg-lightGreen {
	background-color: #7EF7A8;
}

.bg-lightRed {
	background-color: #FF7575;
}

.bg-lightViolet {
	background-color: #ADBCFF;
}

.bg-lightblue {
	background-color: #72D7F7;
}

.btn-yellow {
	background-color: #E9E935;
}
</style>


<style>
.mutedtext {
	color: #9C9C9C;
	font-weight: lighter;
}

.blacktext {
	color: #000000;
	font-weight: lighter;
}
</style>


<style>
.helptext {
	color: #FF0000;
	font-weight: lighter;
}
</style>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Font Awesome CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>noobPage - ${title}</title>

<script type="text/javascript">
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Sketchy Theme -->
<link href="${css}/SketchyTheme.css" rel="stylesheet">

<!-- Bootstrap DataTable css -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/full.css" rel="stylesheet">



</head>

<body>

	<style>
a:hover {
	color: red;
	font-weight: bold;
}
</style>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="flows-navbar.jsp"%>


		<!-- Page content -->
		<div class="content">