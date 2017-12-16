package easypc.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import easypc.backend.dao.UsersDAO;
import easypc.backend.dto.Address;
import easypc.backend.dto.Cart;
import easypc.backend.dto.Users;

public class UsersTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UsersDAO usersDAO;
	private Users user = null;
	private Cart cart = null;
	private Address addr = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("easypc.backend");
		context.refresh();

		usersDAO = (UsersDAO) context.getBean("usersDAO");
	}

	// @Test
	// public void testAdd() {
	// // adding new user
	// user = new Users();
	// user.setFirst_name("Barry");
	// user.setLast_name("Allen");
	// user.setEmail("theflash@gmail.com");
	// user.setContact_number("9988776655");
	// user.setRole("USER");
	// user.setPassword("nottheflash");
	//
	// assertEquals("Failed to add user", true, usersDAO.addUser(user));
	//
	// // billing address
	// addr = new Address();
	// addr.setAddress_line_one("Star Labs");
	// addr.setAddress_line_two("");
	// addr.setCity("Central city");
	// addr.setState("DC-World");
	// addr.setCountry("USA");
	// addr.setPostal_code("123123");
	// addr.setBilling(true);
	//
	// // linking user and his/her address
	// addr.setUser_id(user.getId());
	//
	// assertEquals("Failed to add address", true, usersDAO.addAddress(addr));
	//
	// // if user is not admin/supplier
	// if (user.getRole().equalsIgnoreCase("USER")) {
	//
	// cart = new Cart();
	// cart.setUser(user);
	//
	// assertEquals("Failed to add Cart", true, usersDAO.addCart(cart));
	//
	// // shipping address
	// addr = new Address();
	// addr.setAddress_line_one("Star Labs");
	// addr.setAddress_line_two("");
	// addr.setCity("Central city");
	// addr.setState("DC-World");
	// addr.setCountry("USA");
	// addr.setPostal_code("123123");
	// addr.setShipping(true);
	//
	// addr.setUser_id(user.getId());
	//
	// assertEquals("Failed to add shipping address", true,
	// usersDAO.addAddress(addr));
	// }
	// }

//	@Test
//	public void testAdd() {
//		// adding new user
//		user = new Users();
//		user.setFirst_name("Barry");
//		user.setLast_name("Allen");
//		user.setEmail("theflash@gmail.com");
//		user.setContact_number("9988776655");
//		user.setRole("USER");
//		user.setPassword("nottheflash");
//
//		// if user is not admin/supplier
//		if (user.getRole().equalsIgnoreCase("USER")) {
//
//			cart = new Cart();
//			cart.setUser(user);
//			//linking cart with user
//			user.setCart(cart);
//
//		}
//		assertEquals("Failed to add user", true, usersDAO.addUser(user));
//	}
	
	
//	@Test
//	public void testUpdateCart(){
//		
//		
//		user = usersDAO.getByEmail("theflash@gmail.com");
//		cart = user.getCart();
//		
//		cart.setGrand_total(10580);
//		cart.setCart_lines(2);
//		
//		assertEquals("failed to update cart",true,usersDAO.updateCart(cart));
//		
//		
//	}
	
//	@Test
//	public void testAddAddr(){
//		
//		//add user
//		
//		user = new Users();
//		user.setFirst_name("Barry");
//		user.setLast_name("Allen");
//		user.setEmail("theflash@gmail.com");
//		user.setContact_number("9988776655");
//		user.setRole("USER");
//		user.setPassword("nottheflash");
//
//		assertEquals("Failed to add user", true, usersDAO.addUser(user));
//
//		
//		
//		//add address
//		// billing address
//				addr = new Address();
//				addr.setAddress_line_one("Star Labs");
//				addr.setAddress_line_two("");
//				addr.setCity("Central city");
//				addr.setState("DC-World");
//				addr.setCountry("USA");
//				addr.setPostal_code("123123");
//				addr.setBilling(true);
//				
//				//attaching user to address
//				addr.setUser(user);
//				assertEquals("failed to add address",true,usersDAO.addAddress(addr));
//		
//		//add all shipping addresses
//
//				 // shipping address
//				 addr = new Address();
//				 addr.setAddress_line_one("Star Labs");
//				 addr.setAddress_line_two("");
//				 addr.setCity("Central city");
//				 addr.setState("DC-World");
//				 addr.setCountry("USA");
//				 addr.setPostal_code("123123");
//				 addr.setShipping(true);
//				 
//				 addr.setUser(user);
//								 				
//				 assertEquals("Failed to add shipping address", true,usersDAO.addAddress(addr));
//	}
	
//	@Test
//	public void testAddShipAddr(){
//		
//		user = usersDAO.getByEmail("theflash@gmail.com");
//		
//		//add all shipping addresses 	
//		//
//						 // shipping address
//						 addr = new Address();
//						 addr.setAddress_line_one("Somewhere in Star City");
//						 addr.setAddress_line_two("");
//						 addr.setCity("Star city");
//						 addr.setState("DC-World");
//						 addr.setCountry("USA");
//						 addr.setPostal_code("123123");
//						 addr.setShipping(true);
//						 
//						 addr.setUser(user);
//										 				
//						 assertEquals("Failed to add shipping address", true,usersDAO.addAddress(addr));
//		
//						 
//						 
//	}

	@Test
	public void testAllAdresses(){
		
		user = usersDAO.getByEmail("theflash@gmail.com");
		
		assertEquals("Failed to get shipping Addresses, size doesnt match",2,usersDAO.getShippingAddresses(user).size());
		assertEquals("Failed to get billing Address, size doesnt match","Central city",usersDAO.getBillingAddress(user).getCity());
		
		
		
	}
	
	
}
