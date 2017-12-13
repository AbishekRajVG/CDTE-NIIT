
<!-- spring form tag library -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<style>
.mutedtext {
	color: #9C9C9C;
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









			<div class="card">


				<div class="card-header bg-danger">
					<h4>
						<strong>Add new product</strong>
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

									<em class="help-block mutedtext">Select one Category <i
										class="fa fa-hand-o-up"></i>
									</em>


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
								<div class="col-md-12">
									<center>
										<input type="submit" name="submit" id="submit" value="submit"
											class="btn btn-success" />
									</center>

								</div>

							</div>


						</sf:form>


					</div>
				</div>


			</div>

		</div>


	</div>


</div>