
 <style>
 .bg-yellow{
 	background-color: #E9E935  ;
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
				<li><a class="nav-link ${status3}" href="${contextRoot}/show/all/products">All
						Products</a></li>
			</ul>

			<ul class="nav nav-pills nav-justified ml-auto">

				<li><a class="nav-link ${status1}" href="${contextRoot}/about">About</a>
				</li>

				<li id="contact"><a class="nav-link ${status2}" href="${contextRoot}/contact">Contact</a></li>
			</ul>




		</div>
	</div>
</nav>