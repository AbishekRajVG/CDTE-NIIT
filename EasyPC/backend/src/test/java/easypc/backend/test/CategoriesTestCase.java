package easypc.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dto.Categories;

public class CategoriesTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoriesDAO catsDAO;

	private Categories ctg;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("easypc.backend");
		context.refresh();

		catsDAO = (CategoriesDAO) context.getBean("catsDAO");
	}

	// @Test
	// public void testAddCategories() {
	// ctg = new Categories();
	//
	// ctg.setName("Storage");
	// ctg.setDesc("Hard stuff");
	// ctg.setImageurl("");
	//
	// assertEquals("Successfully added Category", true, ctgDAO.add(ctg));
	//
	// }

	// @Test
	// public void testGetCategory() {
	// ctg = ctgDAO.get(2);
	// assertEquals("Successfully got Category", "CPU", ctg.getName());
	//
	// }

	// @Test
	// public void testUpdateCategory() {
	// ctg = ctgDAO.get(2);
	// ctg.setName("Processor");
	// assertEquals("Successfully got Category",true, ctgDAO.update(ctg));
	//
	// }

	// @Test
	// public void testDeleteCategory() {
	// ctg = ctgDAO.get(2);
	// assertEquals("Successfully deleted Category",true, ctgDAO.delete(ctg));
	//
	// }
	//

	// @Test
	// public void testListCategory() {
	//
	// assertEquals("Successfully got list of Categories", 4,
	// ctgDAO.list().size());
	//
	// }

	@Test
	public void testCRUDCategory() {

		// add operation
		//first
		ctg = new Categories();
		ctg.setName("Graphics Cards");
		ctg.setDesc("Bitchin'");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// second
		ctg = new Categories();
		ctg.setName("CPU");
		ctg.setDesc("Heart");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// third
		ctg = new Categories();
		ctg.setName("MotherBoard");
		ctg.setDesc("the Mother");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// fourth
		ctg = new Categories();
		ctg.setName("Storage");
		ctg.setDesc("Hard stuff");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// third
		ctg = new Categories();
		ctg.setName("Memory");
		ctg.setDesc("Stick Stuff");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// sixth
		ctg = new Categories();
		ctg.setName("Power Supply Units");
		ctg.setDesc("Power");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// seventh
		ctg = new Categories();
		ctg.setName("Cooling Devices");
		ctg.setDesc("Keeping it cool");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// Eighth
		ctg = new Categories();
		ctg.setName("Desktop Cases");
		ctg.setDesc("looking sexy");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		// ninth
		ctg = new Categories();
		ctg.setName("Peripherals");
		ctg.setDesc("Power");
		ctg.setImageurl("");

		assertEquals("Successfully added Category", true, catsDAO.add(ctg));

		
		// // update op
		// ctg = catsDAO.get(2);
		// ctg.setName("RAM");
		// assertEquals("Successfully got Category", true, catsDAO.update(ctg));
		//
		// //delete op
		// assertEquals("Successfully deleted Category",true,
		// catsDAO.delete(ctg));

		// fetching list
		// assertEquals("Successfully got list of Categories", 2,
		// ctgDAO.list().size());

	}

}
