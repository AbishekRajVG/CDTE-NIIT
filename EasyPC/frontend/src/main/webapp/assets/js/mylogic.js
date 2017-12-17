$(function() {

	// tackling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content'); 
	
	if(token.length > 0 && header.length > 0){
		
		$(document).ajaxSend(function(e,xhr,options){
			
			xhr.setRequestHeader(header,token);
			
		}); 
		
	}
	
	
	
	
	// code for jquery dataTable

	var $table = $('#productListTable');

	if ($table.length) {
		// console.log('Ínside the table!');

		var jsonUrl = '';
		if (window.category_id == '') {
			jsonUrl = window.contextRoot + '/json/data/show/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.category_id + '/products';
		}

		$table
				.DataTable({

					"oLanguage" : {
						"sLengthMenu" : " _MENU_ rows",
					},

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 ', '5 ', '10 ', ' ALL ' ] ],
					pageLength : 5,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',

								mRender : function(data, type, row) {
									return '<a href=" '
											+ window.contextRoot
											+ '/show/'
											+ row.id
											+ '/product" data-toggle="tooltip" title="View Product"><img src= " '
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" height="100" width="100"/></a>';
								}
							},

							{
								data : 'name',

								mRender : function(data, type, row) {
									return '<a href=" '
											+ window.contextRoot
											+ '/show/'
											+ row.id
											+ '/product" data-toggle="tooltip" title="View Product"><strong>'
											+ data + '</strong></a>';
								}

							},
							{
								data : 'brand'
							},
							{
								data : 'unit_price',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}

									return data + ' left';
								}

							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									

										if(userRole=='ADMIN'){
											str = '<a href=" '
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-outline-warning"><i class="fa fa-edit"></i>&#160; Edit Product</a>';
										}
									else{
										if (row.quantity > 0){
										
										str = '<a href=" '
												+ window.contextRoot
												+ '/buy/'
												+ data
												+ '/product" class="btn btn-outline-success"><i class="fa fa-cart-plus"></i>&#160; Add to Cart</a>';
									}
										
									
									else str += '<a href="javascript:void(0)" class="btn btn-dark disabled"><i class="fa fa-cart-plus"></i>&#160; Add to Cart</a>';
									
									
									}
									return str;
								}
							}

					]
				});
	}

	// dismissing alert after specific time
	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)

	}


	

	// code for admin dataTable

	var $adminProductsTable = $('#adminProductsTable');
	if ($adminProductsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable.DataTable({

					"oLanguage" : {
						"sLengthMenu" : " _MENU_ rows",
					},

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 ', '30 ', '50 ', ' ALL ' ] ],
					pageLength : 30,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							
							{
								data : 'id'
							},
							
							{
								data : 'code',

								mRender : function(data, type, row) {
									return '<a href=" '
											+ window.contextRoot
											+ '/show/'
											+ row.id
											+ '/product" data-toggle="tooltip" title="View Product"><img src= " '
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" height="100" width="100"/></a>';
								}
							},

							{
								data : 'name',

								mRender : function(data, type, row) {
									return '<a href=" '
											+ window.contextRoot
											+ '/show/'
											+ row.id
											+ '/product" data-toggle="tooltip" title="View Product"><strong>'
											+ data + '</strong></a>';
								}

							},
							{
								data : 'brand'
							},
							{
								data : 'unit_price',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}

									return data + ' left';
								}

							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" checked value="'
												+ row.id
												+ '" alt = "'+ row.name +'" /> <span class="slider round"></span></label>';
									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+  '" alt = "'+ row.name +'" /> <span class="slider round"></span></label>';
									}

									return str;
								}

							},

							{
								data : 'id',
								bSortable : false,
								mRender(data,type,row){
									var str='<a href="'+window.contextRoot+'/manage/'+ data	+'/product" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
									
									return str;
								}
							}

					],
					// toggle switch logic
					initComplete : function(){
						
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on(
								'change',
								function() {

									var checkbox = $(this);
									var checked = checkbox.prop('checked');
									var val_name = checkbox.prop('alt');
									var val = checkbox.prop('value');
									
									
									var dialogue_msg = (checked) ? 'activate <div class="text-success">'+val_name+'</div> ??'
											: 'deactivate <div class="text-danger">'+val_name +'</div> ??';
									var confirm_msg = (checked) ? ( '<div class="text-success">'+val_name +'</div> is back online')
											: ('<div class="text-danger">'+val_name +'</div> is offline');
									

									bootbox.confirm({

										size : 'small',

										message : dialogue_msg,
										callback : function(confirmed) {
											if (confirmed) {
												console.log(val);
												
												// actual code
												var activationUrl = window.contextRoot + '/manage/product/' + val + '/activation'; 
												$.post(activationUrl, function(){
													
													var box = bootbox.alert({
														size : 'small',

														message : confirm_msg
													});
													
													setTimeout(function() {
													    // be careful not to
														// call box.hide() here,
														// which will invoke
														// jQuery's hide method
													    box.modal('hide');
													}, 1000);
													
												});
												
												
											} else {
												checkbox.prop('checked', !checked);
											}
										}
									});

								});
						
						
					}
					
					
					
				});
	}
	
	// validation for category
	
		var $categoryForm = $('#catsForm');
		
		if($categoryForm.length){
			
			$categoryForm.validate({
				
				rules: {
					
					name : {
						
						required : true,
						minlength : 2
						
						
					},
					
					desc : {
						
						required : true
						
					}
					
					
				},
				
				messages : {
					
						name : {
						
						required : '<div class="text-danger">Please enter a Category Name</div>',
						minlength : '<div class="text-danger">The name cant be shorter than 2 charecters</div>'
						
						
					},
					
					desc : {
						
						required : '<div class="text-danger">Please describe the category</div>'
						
					}
					
					
				},
				errorElement : 'em',
				errorPlacement : function(error, element){
					// help block
					error.addClass('help-block');
					// error after i/p
					error.insertAfter(element);
					
				}	
				
			});
		
		
		
		
		
		}
	
		// validation for signin page
		
		var $signinForm = $('#signinForm');
		
		if($signinForm.length){
			
			$signinForm.validate({
				
				rules: {
					
					email : {
						
						required : true,
						email : true
						
						
					},
					
				password : {
						
						required : true
						
					}
					
					
				},
				
				messages : {
					
						email : {
						
						required : '<div class="text-danger">Please enter the registered email</div>',
						minlength : '<div class="text-danger">Please enter a valid email</div>'
						
						
					},
					
					password  : {
						
						required : '<div class="text-danger">Password field is required</div>'
						
					} 
					
					
				},
				errorElement : 'em',
				errorPlacement : function(error, element){
					// help block
					error.addClass('help-block');
					// error after i/p
					error.insertAfter(element);
					
				}	
				
			});
		
		
		
		
		
		}
	
		
		
		
		
		
});