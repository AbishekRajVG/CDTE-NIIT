<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- flows-header -->
<%@include file="../flows-shared/flows-header.jsp"%>

<div class="container">
	<br> <br>

	<div class="row justify-content-center">

		<!-- user details -->
		<div class="col-sm-6">

			<div class="card ">


				<div class="card-header bg-danger text-center">
					<h4>
						<strong>User Details</strong>
					</h4>
				</div>

				<div class="card-block bg-lightViolet">

					<br>
					<div class="card-text">

						<div class="col-md-12">

							<h4>Name : ${registerModel.user.first_name}
								${registerModel.user.last_name}</h4>
							<h4>Email : ${registerModel.user.email}</h4>
							<h4>Contact : ${registerModel.user.contact_number}</h4>
							<h4>Role : ${registerModel.user.role}</h4>
						</div>
					</div>
					<br>
					<div class="text-center">
						<!-- edit user details -->
						<a href="${flowExecutionUrl}&_eventId_personal"
							class="btn btn-warning"><i class="fa fa-edit"></i> edit User
							Details</a>
					</div>
					<br>
				</div>
			</div>
		</div>

		<!-- billing info -->
		<div class="col-sm-6">

			<div class="card ">


				<div class="card-header bg-danger text-center">
					<h4>
						<strong>Billing Info</strong>
					</h4>
				</div>

				<div class="card-block bg-lightBlue">
					<br>

					<div class="card-text">
						<div class="col-md-12">

							<h4>Address : ${registerModel.billing.address_line_one}
								${registerModel.billing.address_line_two}</h4>
							<h4>City : ${registerModel.billing.city}</h4>
							<h4>State : ${registerModel.billing.state}</h4>
							<h4>Country : ${registerModel.billing.country}</h4>
							<h4>Postal Code : ${registerModel.billing.postal_code}</h4>

						</div>


					</div>
					<br>
					<div class="text-center">
						<!-- edit address -->
						<a href="${flowExecutionUrl}&_eventId_billing"
							class="btn btn-warning"><i class="fa fa-edit"></i> edit
							Billing info</a>
					</div>
					<br>
				</div>
			</div>

		</div>

		<!-- success page button -->

		<div>
			<br> <br> <a href="${flowExecutionUrl}&_eventId_submit"
				class="btn btn-success">Confirm details <i class="fa fa-smile-o"
				style="font-size: 25px; color: yellow;"></i></a>
		</div>

	</div>


</div>

<!-- flows-footer -->
<%@include file="../flows-shared/flows-footer.jsp"%>
