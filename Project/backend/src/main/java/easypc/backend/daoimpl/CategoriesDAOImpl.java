package easypc.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dto.Categories;

@Repository("catsDAO")
public class CategoriesDAOImpl implements CategoriesDAO {

	private static List<Categories> cats = new ArrayList<>();

	static {
		// first category

		Categories ctg = new Categories();
		ctg.setId(1);
		ctg.setName("Graphics Cards");
		ctg.setDesc("Bitchin'");
		ctg.setImageURL("");

		cats.add(ctg);

		// second
		ctg = new Categories();
		ctg.setId(2);
		ctg.setName("CPU");
		ctg.setDesc("Heart");
		ctg.setImageURL("");

		cats.add(ctg);

		// third
		ctg = new Categories();
		ctg.setId(3);
		ctg.setName("MotherBoard");
		ctg.setDesc("the Mother");
		ctg.setImageURL("");

		cats.add(ctg);

		// fourth
		ctg = new Categories();
		ctg.setId(4);
		ctg.setName("Storage");
		ctg.setDesc("Hard stuff");
		ctg.setImageURL("");
		cats.add(ctg);

		// third
		ctg = new Categories();
		ctg.setId(5);
		ctg.setName("Memory");
		ctg.setDesc("Stick Stuff");
		ctg.setImageURL("");

		cats.add(ctg);

		// sixth
		ctg = new Categories();
		ctg.setId(6);
		ctg.setName("Power Supply Units");
		ctg.setDesc("Power");
		ctg.setImageURL("");

		cats.add(ctg);

		// seventh
		ctg = new Categories();
		ctg.setId(7);
		ctg.setName("Cooling Devices");
		ctg.setDesc("Keeping it cool");
		ctg.setImageURL("");

		cats.add(ctg);
		
		// Eighth
		ctg = new Categories();
		ctg.setId(8);
		ctg.setName("Desktop Cases");
		ctg.setDesc("looking sexy");
		ctg.setImageURL("");

		cats.add(ctg);
		
		// ninth
		ctg = new Categories();
		ctg.setId(9);
		ctg.setName("Peripherals");
		ctg.setDesc("Power");
		ctg.setImageURL("");

		cats.add(ctg);
		

	}

	@Override
	public List<Categories> list() {

		return cats;
	}

	@Override
	public Categories get(int id) {

		for (Categories ctg : cats) {
			if (ctg.getId() == id) {
				return ctg;
			}
		}

		return null;
	}

}
