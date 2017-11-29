
//not working MARK

$(function() {
	// active menu logic
	switch (menu) {

	case 'About EasyPC':
		$('#about').addClass('active');
		break;

	case 'Contact US':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#allproducts').addClass('active');
		break;

	default:
		$('#allproducts').addClass('active');
		$('#a_'+ menu).addClass('active');
		break;

	}

});

// $(function(){
// //active menu logic
//
// $("#about a:contains('About')").parent().addClass('active');
// $("#contact a:contains('Contact')").parent().addClass('active');
// $("#home a:contains('Home')").parent().addClass('active');
// });

// $( document ).on( 'click', '.navbar-nav ml-auto li', function ( e ) {
// $( this ).addClass( 'active' ).siblings().removeClass( 'active' );
// } );
