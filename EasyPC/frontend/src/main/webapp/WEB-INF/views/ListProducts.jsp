 <style>
 .bg-niceGreen{
 	background-color:	#51BAF2;
 }

</style>


<div class="container">

	<div class="row">

		<!-- Sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Product list -->
		<div class="col-md-9">

			<!-- Bread crumb Bootstrap component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${onShowAll==true}">
						<h1 class="my-4"></h1>

						<script>
							window.category_id = '';
						</script>

						<ol class="breadcrumb bg-niceGreen">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li class="active">--> All Products</li>
						</ol>
					</c:if>

					<c:if test="${onCat==true}">
						<h1 class="my-4"></h1>

						<script>
							window.category_id = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li class="active">--> Category</li>
							<li class="active">--> ${category.name}</li>
						</ol>
					</c:if>

				</div>

			</div>

			<div class="row">

				<div class="col-xs-12 container-fluid">

					<table id="productListTable" class="table table-bordered">

						<thead class="table-danger">

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Stock</th>
								<th></th>
								
							</tr>

						</thead>
						
				</table>

				</div>


			</div>

		</div>


	</div>



</div>