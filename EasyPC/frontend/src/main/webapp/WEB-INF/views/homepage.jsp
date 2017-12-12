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

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Font Awesome CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

<style>a:hover{color:red;
			   font-weight: bold;}</style>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>


		<div class="content">

			<!-- Page Content -->
			<c:if test="${onHome==true}">
				<!-- Loads only when user clicks Home -->
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${onAbout==true}">
				<!-- Loads only when user clicks About -->
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${onContact==true}">
				<!-- Loads only when user clicks Contact -->
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${onShowAll==true or onCat==true}">
				<!-- Loads only when user clicks All products or categories -->
				<%@include file="ListProducts.jsp"%>
			</c:if>
			
			<c:if test="${onViewProduct==true}">
				<!-- Loads only when user clicks View Products -->
				<%@include file="ViewProduct.jsp"%>
			</c:if>
			
			<c:if test="${onManageProducts==true}">
				<!-- Loads only when user clicks View Products -->
				<%@include file="ProdManagement.jsp"%>
			</c:if>


		</div>

		<!-- footer -->
		<%@include file="./shared/footer.jsp"%>



		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- data table plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- data table script-->
		<script src="${js}/dataTables.bootstrap4.js"></script>




		<!-- my logic JS  -->
		<script src="${js}/mylogic.js"></script>

	</div>

</body>

</html>
