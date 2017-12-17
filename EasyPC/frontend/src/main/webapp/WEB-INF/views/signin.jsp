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
.bg-lightGreen {
	background-color: #7EF7A8;
}

.bg-lightRed {
	background-color: #FF7575;
	.
	bg-yellow
	{
	background-color
	:
	#E9E935;
}

.bg-lightyellow {
	background-color: #FFFFAA;
}
}
</style>
	<style>
a:hover {
	color: red;
	font-weight: bold;
}
</style>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top ">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home"><img
					src="${images}/logo.jpg" class="img-rectangle" width="100"
					height="40"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive"></div>
			</div>
		</nav>
		<br> <br>



		<div class="content">

			<!-- Page Content -->

			<div class="container">
				<div class="row justify-content-center">

					<div class="col-md-6">

						<c:if test="${not empty msg}">
							<div class="col-xs-12">

								<div class="alert alert-danger" role="alert">

									<button type="button" class="close" data-dismiss="alert"></button>

									${msg}

								</div>

							</div>
						</c:if>
						
						<!-- Sign out message -->
						<c:if test="${not empty Outmsg}">
							<div class="col-xs-12">

								<div class="alert alert-success" role="alert">

									<button type="button" class="close" data-dismiss="alert"></button>

									${Outmsg}

								</div>

							</div>
						</c:if>

						<div class="card ">


							<div class="card-header bg-danger text-center">
								<h4>
									<strong>Sign in </strong>
								</h4>
							</div>

							<div class="card-block bg-lightTeal">


								<div class="card-text">
									<!-- Form -->
									<form class="form-horizontal" action="${contextRoot}/signin"
										method="POST" id="signinForm">

										<br>



										<!-- User Name - Email  -->
										<div class="form-group">
											<label class="control-label col-md-4" for="email">Email
												: </label>

											<div class="col-md-12">

												<input type="text" name="email" id="email"
													placeholder="username@example.com" class="form-control" />
											</div>


										</div>

										<!-- Password -->
										<div class="form-group">
											<label class="control-label col-md-4" for="password">Password
												:</label>

											<div class="col-md-12">

												<input type="password" name="password" id="password"
													placeholder="password" class="form-control" />

											</div>

										</div>



										<div class="form-group">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
											<!-- submit button -->
											<div class="col-md-12 row justify-content-center">

												<input type="submit" name="submit" id="submit"
													value="Sign in " class="btn btn-success">



											</div>

										</div>


									</form>
								</div>
							</div>

							<div class="card-footer bg-lightTeal text-right">
								New to EasyPC ?? <a href="${contextRoot}/register">Sign up
									here</a>
							</div>


						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- footer -->
		<%@include file="./shared/footer.jsp"%>



		<!-- jquery -->
		<script src="${js}/jquery.js"></script>

		<!-- jQuery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>


		<!-- my logic JS  -->
		<script src="${js}/mylogic.js"></script>

	</div>

</body>

</html>
