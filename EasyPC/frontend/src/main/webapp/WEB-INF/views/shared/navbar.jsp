<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<style>
.bg-yellow {
	background-color: #E9E935;
}
</style>

<style>
.bg-lightyellow {
	background-color: #FFFFAA;
}

.btn-yellow {
	background-color: #E9E935;
}
</style>




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
		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="nav nav-pills nav-justified">
				<li><a class="nav-link ${status3}"
					href="${contextRoot}/show/all/products">All Products</a></li>
			</ul>


			<ul class="nav nav-pills nav-justified">
				<security:authorize access="hasAuthority('ADMIN')">
					<li><a class="nav-link ${status4}"
						href="${contextRoot}/manage/products">Product Management</a></li>
				</security:authorize>
			</ul>

			<ul class="nav nav-pills nav-justified ml-auto">

				<li><a class="nav-link ${status1}" href="${contextRoot}/about">About</a>
				</li>

				<li id="contact"><a class="nav-link ${status2}"
					href="${contextRoot}/contact">Contact</a></li>


				<security:authorize access="isAnonymous()">
					<li><a class="nav-link ${status5}"
						href="${contextRoot}/register">Sign Up</a></li>

					<li><a class="nav-link ${status6}"
						href="${contextRoot}/signin">Sign in</a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li>
						<div class="dropdown show">
							<a class="btn btn-yellow dropdown-toggle"
								href="javascript:void(0)" id="dropdownMenuLink1"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> welcome, <strong>${userModel.fullname}</strong></a>

							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<security:authorize access="hasAuthority('USER')">
									<a class="dropdown-item" href="${contextRoot}/cart/show"><i
										class="fa fa-cart-arrow-down"> </i> <span
										class="badge badge-primary">${userModel.cart.cart_lines}</span>
										- &#8377; ${userModel.cart.grand_total}</a>
								</security:authorize>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="${contextRoot}/perform-signout">Sign
									out</a>
							</div>
						</div>

					</li>
				</security:authorize>
			</ul>




		</div>
	</div>
</nav>
<br>

<<script>
window.userRole ='${userModel.role}';
</script>
