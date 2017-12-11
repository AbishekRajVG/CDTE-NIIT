
$(function() {

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
					
					"oLanguage": {
					      "sLengthMenu": " _MENU_ rows",
					    },			
					
					
					lengthMenu : [ [ -1, 3, 5, 10,20 ],
							[ ' All ','3 ', '5 ', '10 ','20'] ],
					pageLength : 5,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data: 'code',
								
								mRender: function(data, type, row){
									return '<a href=" '
									+ window.contextRoot
									+ '/show/'
									+ row.id
									+ '/product" data-toggle="tooltip" title="View Product"><img src= " ' + window.contextRoot + '/resources/images/'+ data +'.jpg" height="80" width="80"/></a>' ;
								}
							},

							{
								data : 'name',
								
								
								mRender: function(data, type, row){
									return '<a href=" '
									+ window.contextRoot
									+ '/show/'
									+ row.id
									+ '/product" data-toggle="tooltip" title="View Product">'+ data +'</a>' ;
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
								mRender : function(data, type, row){
									
									if(data < 1){
										return '<span style="color:red">Out of Stock</span>';
									}
									
									return data + 'left';
								}
									
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									
									var str='';
									
									if(row.quantity > 0)
										
										str = '<a href=" '
												+ window.contextRoot
												+ '/buy/'
												+ data
												+ '/product" class="btn btn-outline-success"><i class="fa fa-cart-plus"></i>Add to Cart</a>';

									else
										

										str += '<a href="javascript:void(0)" class="btn btn-dark disabled"><i class="fa fa-cart-plus"></i>Add to Cart</a>';

									
									
									return str;
								}
							}

					]
				});
	}

});