
<style>
.bg-niceGreen {
	background-color: #51BAF2;
}

#myImg {
	border-radius: 5px;
	cursor: pointer;
	transition: 0.3s;
}

#myImg:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
	text-align: center;
	color: #ccc;
	padding: 10px 0;
	height: 150px;
}

/* Add Animation */
.modal-content, #caption {
	-webkit-animation-name: zoom;
	-webkit-animation-duration: 0.6s;
	animation-name: zoom;
	animation-duration: 0.6s;
}

@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close {
	
	top: 15px;
	right: 35px;
	color: #f1f1f1;
	font-size: 40px;
	font-weight: bold;
	transition: 0.3s;
}

.close:hover, .close:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
}
</style>




<div class="container ">
	<br> <br>
	<!-- bread crumb -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb bg-niceGreen">

				<li><a href="${contextRoot}/home"> Home </a> --></li>
				<li><a href="${contextRoot}/show/all/products"> All
						Products </a> --></li>
				<li><a href="${contextRoot}/show/category/${product.category_id}/products">back to Category</a> --></li>
				<li class="active">${product.name}</li>

			</ol>


		</div>
	</div>

	<br> <br>


	<!-- actual product -->
	<div class="row">

		<!-- product image -->
		<div class="col-xs-10 col-sm-6">

			<div class="tumbnail">

				<img id="myImg" src="${images}/${product.code}.jpg"
					class="img img-responsive" height=500 width=500 />


			</div>

			<!-- The Modal -->
			<div id="myModal" class="modal">
				<span class="close"></span> <img class="modal-content"
					id="img01">
				<div id="caption"></div>
			</div>



		</div>

		<!-- Product details -->
		<div class="col-xs-12 col-sm-6">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${product.unit_price}</strong>
			</h4>
			<hr />



			<c:choose>

				<c:when test="${product.quantity < 1}">
					<h6>
						<strong><span style="color: red">Out of Stock</span></strong> --
						Sorry! check back soon.
					</h6>
					<hr />
				</c:when>

				<c:otherwise>
					<h6>
						<strong>In Stock - </strong> ${product.quantity} left
					</h6>
					<hr />
				</c:otherwise>


			</c:choose>


			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript:void(0)" class="btn btn-dark disabled"><i
						class="fa fa-cart-plus"></i> Add to Cart  </a>

				</c:when>

				<c:otherwise>

					<a href="${contextRoot}/buy/${product.id}/product"
						class="btn btn-outline-success"><i class="fa fa-cart-plus"></i>
						Add to Cart &#160; </a>

				</c:otherwise>


			</c:choose>




			<a href="${contextRoot}/show/all/products"
				class="btn btn-outline-info"><i class="fa fa-history"></i> Back
				to All Products</a>




		</div>
	</div>
</div>

<script>
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the image and insert it inside the modal - use its "alt" text as a caption
	var img = document.getElementById('myImg');
	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption");
	img.onclick = function() {
		modal.style.display = "block";
		modalImg.src = this.src;
		captionText.innerHTML = this.alt;
	}

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
</script>


