package easypc.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import easypc.backend.dao.CartLineDAO;
import easypc.backend.dao.ProductsDAO;
import easypc.backend.dao.UsersDAO;
import easypc.backend.dto.Cart;
import easypc.backend.dto.CartLine;
import easypc.backend.dto.Products;
import easypc.backend.dto.Users;



public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductsDAO productDAO;
	private static UsersDAO userDAO;
	
	
	private CartLine cartLine = null;
	 
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("easypc.backend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductsDAO)context.getBean("prodDAO");
		userDAO = (UsersDAO)context.getBean("usersDAO");
	}
	

	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		Users user = userDAO.getByEmail("superman@dc.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Products product = productDAO.get(5);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnit_price() * cartLine.getProductCount());
		
		cart.setCart_lines(cart.getCart_lines() + 1);
		cart.setGrand_total(cart.getGrand_total() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	 
	
	
//	@Test
//	public void testUpdateCartLine() {
//
//		// fetch the user and then cart of that user
//		Users user = userDAO.getByEmail("absr@gmail.com");		
//		Cart cart = user.getCart();
//				
//		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
//		
//		cartLine.setProductCount(cartLine.getProductCount() + 1);
//				
//		double oldTotal = cartLine.getTotal();
//				
//		cartLine.setTotal(cartLine.getProduct().getUnit_price() * cartLine.getProductCount());
//		
//		cart.setGrand_total(cart.getGrand_total() + (cartLine.getTotal() - oldTotal));
//		
//		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	
//
//		
//	}
	
	
	
}
