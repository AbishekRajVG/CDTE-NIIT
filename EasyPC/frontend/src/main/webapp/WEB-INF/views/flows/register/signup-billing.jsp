<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- flows-header -->
<%@include file="../flows-shared/flows-header.jsp"%>

<div class="container">
	<br> <br>
	<div class="row justify-content-center">

		<div class="col-md-8">

			<div class="card ">


				<div class="card-header bg-danger text-center">
					<h4>
						<strong>Billing Information</strong>
					</h4>
				</div>

				<div class="card-block bg-lightBlue">


					<div class="card-text">	
						<!-- Form -->
						<sf:form class="form-horizontal" method="POST" id="billingForm"
							modelAttribute="billing">

							<br>

							<!-- address lines  -->
							<div class="form-group">
								<label class="control-label col-md-4" for="address_line_one">Address
									: </label>

								<div class="col-md-12">
									<!-- first -->
									<sf:input type="text" path="address_line_one"
										id="address_line_one" placeholder="line 1"
										class="form-control" />
									<sf:errors path="address_line_one" class="helptext"
										element="em" />
									<!-- last -->
									<sf:input type="text" path="address_line_two"
										id="address_line_two" placeholder="line 2"
										class="form-control" />
									<sf:errors path="address_line_two" class="helptext"
										element="em" />
								</div>


							</div>


							<!-- city -->
							<div class="form-group">
								<label class="control-label col-md-4" for="city">City :</label>

								<div class="col-md-12">

									<sf:input type="text" path="city" id="city"
										placeholder="city name" class="form-control" />
									<sf:errors path="city" class="helptext" element="em" />
								</div>

							</div>

							<!-- state -->
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State
									:</label>

								<div class="col-md-12">

									<sf:input type="text" path="state" id="state"
										placeholder="state" class="form-control" />
									<sf:errors path="state" class="helptext" element="em" />
								</div>

							</div>

							<!-- country -->
							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country Name :</label>

								<div class="col-md-12">

									<sf:input type="text" path="country" id="country"
										placeholder="Country Name " class="form-control" />
									<sf:errors path="country" class="helptext" element="em" />
								</div>

							</div>

							<!-- postal_code -->
							<div class="form-group ">
								<label class="control-label col-md-4">Postal Code :</label>

								<div class="col-md-12 ">
									<sf:input type="text" path="postal_code" id="postal_code"
										placeholder="postal code" class="form-control" />
									<sf:errors path="postal_code" class="helptext" element="em" />

								</div>
							</div>

							<div class="form-group">
								<!-- submit button -->
								<div class="col-md-12 row justify-content-center">

									<button type="submit" class="btn btn-danger"
										name="_eventId_personal"><i class="fa fa-arrow-circle-left"></i> (back) Sign up</button>

									<button type="submit" class="btn btn-success"
										name="_eventId_confirm">Confirm <i class="fa fa-arrow-circle-right"></i></button>



								</div>

							</div>


						</sf:form>


					</div>
				</div>


			</div>

		</div>

	</div>


</div>

<!-- flows-footer -->
<%@include file="../flows-shared/flows-footer.jsp"%>
