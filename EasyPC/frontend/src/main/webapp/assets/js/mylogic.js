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
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 rows  ', '5 rows  ', '10 rows  ', '  all rows  ' ] ],
					pageLength : 5,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data: 'code',
								mRender: function(data, type, row){
									return '<img src= " ' + window.contextRoot + '/resources/images/'+ data +'.jpg" height="80" width="80"/>' ;
								}
							},

							{
								data : 'name'
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
								data : 'quantity'
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '<a href=" '
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-outline-info"><i class="fa fa-eye"></i></a> &#160;';
									str += '<a href=" '
											+ window.contextRoot
											+ '/buy/'
											+ data
											+ '/product" class="btn btn-outline-success"><i class="fa fa-cart-plus"></i></a>';

									return str;
								}
							}

					]
				});
	}

});