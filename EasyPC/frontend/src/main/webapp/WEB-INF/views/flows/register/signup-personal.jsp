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
						<strong>create your EasyPC account</strong>
					</h4>
				</div>

				<div class="card-block bg-lightViolet">


					<div class="card-text">
						<!-- Form -->
						<sf:form class="form-horizontal" method="POST" id="registerForm"
							modelAttribute="user">

							<br>

							<!-- name  -->
							<div class="form-group">
								<label class="control-label col-md-4" for="first_name">Name
									: </label>

								<div class="col-md-12">
									<!-- first -->
									<sf:input type="text" path="first_name" id="first_name"
										placeholder="First Name" class="form-control" />
									<sf:errors path="first_name" class="helptext" element="em" />
									<!-- last -->
									<sf:input type="text" path="last_name" id="last_name"
										placeholder="Last Name" class="form-control" />
									<sf:errors path="last_name" class="helptext" element="em" />
								</div>


							</div>


							<!-- email -->
							<div class="form-group">
								<label class="control-label col-md-4" for="email">Email
									:</label>

								<div class="col-md-12">

									<sf:input type="text" path="email" id="email"
										placeholder="batman@example.com" class="form-control" />
									<sf:errors path="email" class="helptext" element="em" />
								</div>

							</div>

							<!-- contact_number -->
							<div class="form-group">
								<label class="control-label col-md-4" for="contact_number">Contact
									number :</label>

								<div class="col-md-12">

									<sf:input type="text" path="contact_number" id="contact_number"
										placeholder="+91 " class="form-control" />
									<sf:errors path="contact_number" class="helptext" element="em" />
								</div>

							</div>

							<!-- password -->
							<div class="form-group">
								<label class="control-label col-md-4" for="password">Enter
									Password :</label>

								<div class="col-md-12">

									<sf:input type="password" path="password" id="password"
										placeholder="your password" class="form-control" />
									<sf:errors path="password" class="helptext" element="em" />
								</div>

							</div>

							<!-- Confirm pwd -->
							<div class="form-group ">
								<label class="control-label col-md-4">Confirm Password :</label>

								<div class="col-md-12 ">
									<sf:input type="password" path="password2" id="password2"
										placeholder="re-type password" class="form-control" />
									<sf:errors path="password2" class="helptext" element="em" />

								</div>
							</div>

							<!-- User Role -->
							<div class="form-group">
								<label class="control-label col-md-4" for="password">Select
									Role :</label>

								<div>
									&#160;&#160;&#160;&#160; <label class="radio-inline col-md-1">
										<sf:radiobutton path="role" value="USER" checked="checked" />User
									</label> <label class="radio-inline col-md-4"> <sf:radiobutton
											path="role" value="SUPPLIER" />Supplier
									</label>
								</div>

							</div>




							<div class="form-group">
								<!-- submit button -->
								<div class="col-md-12 row justify-content-center">

									<button type="submit" class="btn btn-success"
										name="_eventId_billing">
										Sign up <i class="fa fa-arrow-circle-right"></i>
									</button>


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
