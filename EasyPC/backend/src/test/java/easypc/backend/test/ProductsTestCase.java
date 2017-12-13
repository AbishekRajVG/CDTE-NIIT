package easypc.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Products;

public class ProductsTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductsDAO prodDAO;
	private static Products prod;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("easypc.backend");
		context.refresh();

		prodDAO = (ProductsDAO) context.getBean("prodDAO");

	}

//	 @Test
//	 public void TestCRUDProducts() {
//	
//	 // add operation
//	
//	 // first
//	 prod = new Products();
//	
//	 prod.setName("Asus Strix GTX 1080 ti");
//	 prod.setBrand("Asus");
//	 prod.setDescription("Base clock 1632 MHz Boost Clock (OC Mode) featuring 11GB GDDR5X 352-bit memory, 3584 CUDA cores, and 11GB Frame Buffer");
//	 prod.setUnit_price(65000);
//	 prod.setQuantity(30);
//	 prod.setActive(true);
//	 prod.setCategory_id(1);
//	 prod.setSupplier_id(3);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // second
//	 prod = new Products();
//	
//	 prod.setName("Intel Core i7 8700k");
//	 prod.setBrand("Intel");
//	 prod.setDescription("Intel LGA1151 8th Gen Core i7-8700K Processor 6 Cores/12 Threads ");
//	 prod.setUnit_price(45000);
//	 prod.setQuantity(40);
//	 prod.setActive(true);
//	 prod.setCategory_id(2);
//	 prod.setSupplier_id(1);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // third
//	 prod = new Products();
//	
//	 prod.setName("AMD Ryzen Threadripper 1950X");
//	 prod.setBrand("AMD");
//	 prod.setDescription("AMD Ryzen Threadripper 1950X (16-core/32-thread) Desktop Processor ");
//	 prod.setUnit_price(55000);
//	 prod.setQuantity(32);
//	 prod.setActive(true);
//	 prod.setCategory_id(2);
//	 prod.setSupplier_id(1);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // fourth
//	 prod = new Products();
//	
//	 prod.setName("Corsair Vengeance Pro 16GB");
//	 prod.setBrand("Corsair");
//	 prod.setDescription("2 x 8 GB kit DDR4 2400mhz");
//	 prod.setUnit_price(10000);
//	 prod.setQuantity(50);
//	 prod.setActive(true);
//	 prod.setCategory_id(5);
//	 prod.setSupplier_id(3);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // fifth
//	 prod = new Products();
//	
//	 prod.setName("Samsung 850 EVO 500GB");
//	 prod.setBrand("Samsung");
//	 prod.setDescription("Samsung 850 EVO 500GB with R/W 540MB/s and 520MB/s respectively ");
//	 prod.setUnit_price(25000);
//	 prod.setQuantity(10);
//	 prod.setActive(true);
//	 prod.setCategory_id(4);
//	 prod.setSupplier_id(3);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // sixth
//	 prod = new Products();
//	
//	 prod.setName("GIGABYTE Z370 Motherboard");
//	 prod.setBrand("Gigabyte");
//	 prod.setDescription("Intel LGA1151/ Z370/ ATX/ M.2/ RGB Fusion/ SLI ");
//	 prod.setUnit_price(15000);
//	 prod.setQuantity(30);
//	 prod.setActive(true);
//	 prod.setCategory_id(3);
//	 prod.setSupplier_id(3);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
//	
//	 // seventh
//	 prod = new Products();
//	
//	 prod.setName("Logitech G810 RGB Gaming Keyboard");
//	 prod.setBrand("Logitech");
//	 prod.setDescription("Logitech G810 Orion Spectrum RGB Mechanical Gaming Keyboard w/ Ultra-Responsive Romer-G Mechanical Key Switches ");
//	 prod.setUnit_price(10000);
//	 prod.setQuantity(15);
//	 prod.setActive(true);
//	 prod.setCategory_id(9);
//	 prod.setSupplier_id(3);
//	
//	 assertEquals("Something went wrong while inserting product", true,
//	 prodDAO.add(prod));
	//
//	 // update Operation
//	 prod = prodDAO.get(6);
//	
//	 prod.setName("GIGABYTE Z370 AORUS Gaming 7 ");
//	 assertEquals("Something went wrong while updating product", true,
//	 prodDAO.update(prod));
//	
	// // delete Operation
	// assertEquals("Something went wrong while updating product", true,
	// prodDAO.delete(prod));
	//
	// // fetch
	// //assertEquals("Something went wrong while fetching products list", 9,
	// prodDAO.list().size());
	//
	// }

//	@Test
//	public void testListActiveProducts() {
//		assertEquals("Something went wrong while fetching products list", 6, prodDAO.listActiveProducts().size());
//	}
//
//	@Test
//	public void testListActiveProductsByCategory() {
//		assertEquals("Something went wrong while fetching products list", 2,
//				prodDAO.listActiveProductsByCategory(2).size());
//		assertEquals("Something went wrong while fetching products list", 1,
//				prodDAO.listActiveProductsByCategory(9).size());
//
//	}
//
//	@Test
//	public void testGetLatestActiveProducts() {
//		assertEquals("Something went wrong while fetching products list", 3,
//				prodDAO.getLatestActiveProducts(3).size());
//		
//
//	}

}





















