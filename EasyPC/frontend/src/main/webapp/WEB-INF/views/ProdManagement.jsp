
<!-- spring form tag library -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


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



<br>
<br>



<div class="container">
	<div class="row justify-content-center">

		<div class="col-md-8">

			<c:if test="${not empty msg}">
				<div class="col-xs-12">

					<div class="alert ${alertcolor}" role="alert">

						<button type="button" class="close" data-dismiss="alert"></button>

						${msg}

					</div>

				</div>
			</c:if>









			<div class="card ">


				<div class="card-header bg-danger text-center">
					<h4>
						<strong>${cardTitle}</strong>
					</h4>
				</div>

				<div class="card-block bg-lightyellow">


					<div class="card-text">
						<!-- Form -->
						<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/manage/products" method="POST"
							enctype="multipart/form-data">

							<br>

							<!-- category -->
							<div class="form-group">
								<label class="control-label col-md-4" for="category_id">Product
									Category : </label>

								<div class="col-md-12">

									<sf:select path="category_id" id="category_id"
										class="form-control" items="${categories}" itemLabel="name"
										itemValue="id" />

									<em class="help-block blacktext">Select one Category<i
										class="fa fa-hand-o-up"></i>
									</em>

									<c:if test="${product.id == 0}">

										<button type="button" data-toggle="modal"
											data-target="#catModal"
											class="btn btn-outline-primary btn-sm pull-right">
											OR add a new category</button>

									</c:if>


								</div>


							</div>



							<!-- name  -->
							<div class="form-group">
								<label class="control-label col-md-4" for="name">Product
									Name : </label>

								<div class="col-md-12">

									<sf:input type="text" path="name" id="name"
										placeholder="Product Name" class="form-control" />
									<sf:errors path="name" class="helptext" element="em" />
								</div>


							</div>

							<!-- brand -->
							<div class="form-group">
								<label class="control-label col-md-4" for="brand">Product
									Brand :</label>

								<div class="col-md-12">

									<sf:input type="text" path="brand" id="brand"
										placeholder="Product Brand " class="form-control" />
									<sf:errors path="brand" class="helptext" element="em" />
								</div>

							</div>

							<!-- Description -->
							<div class="form-group">
								<label class="control-label col-md-4" for="description">Product
									Description :</label>

								<div class="col-md-12">
									<sf:textarea class="col-md-12" path="description"
										id="description" rows="4" placeholder="Product Description" />
									<sf:errors path="description" class="helptext" element="em" />
									<!-- <em class="help-block helptext">Please Enter Description!</em>  -->
								</div>

							</div>

							<!-- price -->
							<div class="form-group">
								<label class="control-label col-md-4" for="unit_price">Product
									Price : </label>

								<div class="col-md-12">

									<sf:input type="float" path="unit_price" id="unit_price"
										placeholder="Product Price per unit" class="form-control" />
									<sf:errors path="unit_price" class="helptext" element="em" />
								</div>


							</div>

							<!-- quantity -->
							<div class="form-group">
								<label class="control-label col-md-4" for="quantity">Quantity
									: </label>

								<div class="col-md-12">

									<sf:input type="number" path="quantity" id="quantity"
										placeholder="Enter initial quantity" class="form-control" />
								</div>


							</div>

							<!-- image -->
							<div class="form-group">
								<label class="control-label col-md-4" for="file">Product
									Image : </label>

								<div class="col-md-12">

									<sf:input type="file" path="file" id="file"
										class="form-control" />
									<sf:errors path="file" class="helptext" element="em" />

								</div>


							</div>


							<div class="form-group">


								<!-- hidden fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplier_id" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />



								<!-- submit button -->
								<div class="col-md-12 row justify-content-center">

									<input type="submit" name="submit" id="submit"
										value="${submitbutton}" class="btn btn-success" /> &#160;
									<c:if test="${submitbutton == 'Edit product'}">
										<input type="submit" name="submit" id="submit" value="Cancel"
											class="btn btn-danger"
											onclick="http://localhost:8080/frontend/manage/products" />
									</c:if>


								</div>

							</div>


						</sf:form>


					</div>
				</div>


			</div>

		</div>


	</div>
	<br> <br>
	<div class="row justify-content-center">

		<div class="col-xs-12">
			<h3>
				<strong>Products already in the database...</strong>
			</h3>
			<hr />
			<div class="col-xs-12">

				<div style="overflow: auto">

					<!-- products table for admin -->
					<table id="adminProductsTable" class="table table-bordered">

						<thead class="table-danger">
							<tr>
								<th>ID</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Stock</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>


					</table>


				</div>


			</div>


		</div>

	</div>




	<div class="modal fade" id="catModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header bg-danger">
					<h5 class="modal-title">Add new category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body bg-lightyellow">
					<sf:form modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">

						<div class="form group">

							<label for="Catname" class="control-label col-md-4">Category
								name : </label>
							<div class="col-md-12">
								<sf:input type="text" path="name" id="Catname"
									class="form-control" />
							</div>
						</div>

						<div class="form group">

							<label for="name" class="control-label col-md-4">Category
								Desc : </label>
							<div class="col-md-12">
								<sf:textarea cols="" rows="5" type="text" path="desc" id="desc"
									class="form-control" />
							</div>
						</div>



						<div class="form group">
							<input type="submit" value="Add Category" class="btn btn-success" />
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>