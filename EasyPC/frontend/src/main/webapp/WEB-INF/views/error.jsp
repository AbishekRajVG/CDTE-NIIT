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
.bg-yellow {
	background-color: #E9E935;
}
</style>

	<div class="wrapper">

		<!-- NavBar -->




		<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top ">
			<div class="container">
				<a class="navbar-brand class=" nav nav-pills nav-justified
					ml-auto"" href="${contextRoot}/home"><img
					src="${images}/logo.jpg" class="img-rectangle" width="100"
					height="40"></a> <a class="nav nav-pills nav-justified mr-auto"
					href="${contextRoot}/home"> <--- GO Home</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>


			</div>
		</nav>

		<!-- /NavBar -->
		<br> <br>
		<div class="content">

			<div class="container">

				<div class="row">


					<div class="col-xs-12 col-sm-6">

						<div class="tumbnail">

							<img src="${images}/curiousSparrow.gif"
								class="img img-responsive" height=500 width=500 />

						</div>


					</div>


					<div class="col-xs-12 col-sm-6">
						<br> <br> <br>
						<div class="jumbotron">

							<h1>
								<strong>${errorTitle}</strong>
							</h1>
							<hr />

							<blockquote style="word-wrap:break-word">${errorDesc}</blockquote>
							<br>

							<button type="button" class="btn btn-outline-danger"
								data-toggle="collapse" data-target="#stacktrace">View
								Full Stack Trace</button>

							<div id="stacktrace" class="collapse">

								<blockquote style="word-wrap:break-word">${StackTrace}</blockquote>


							</div>


						</div>




					</div>


				</div>

			</div>

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
