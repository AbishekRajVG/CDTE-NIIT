package eacypc.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eacypc.backend.dao.CategoriesDAO;
import eacypc.backend.dto.Categories;

@Repository
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

	}

	@Override
	public List<Categories> list() {
		
		return cats;
	}

}
