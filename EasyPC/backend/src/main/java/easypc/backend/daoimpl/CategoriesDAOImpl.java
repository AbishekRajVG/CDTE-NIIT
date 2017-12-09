package easypc.backend.daoimpl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dto.Categories;

@Repository("catsDAO")
@Transactional
public class CategoriesDAOImpl implements CategoriesDAO {

	@Autowired
	private SessionFactory sessFac;

	@Override
	public List<Categories> list() {

		String selectActiveCtg = "FROM Categories WHERE active = :active";

		Query query = sessFac.getCurrentSession().createQuery(selectActiveCtg);
		query.setParameter("active", true);

		return query.getResultList();
	}

	// for getting a single category
	@Override
	public Categories get(int id) {

		// for (Categories ctg : cats) {
		// if (ctg.getId() == id) {
		// return ctg;
		// }
		// }

		return sessFac.getCurrentSession().get(Categories.class, Integer.valueOf(id));
	}
	@Override
	public boolean add(Categories ctg) {

		try {
			// adding category to DB
			sessFac.getCurrentSession().persist(ctg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	@Override
	public boolean update(Categories ctg) {
		try {
			// adding category to DB
			sessFac.getCurrentSession().update(ctg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Categories ctg) {
		ctg.setActive(false);
		try {
			// adding category to DB
			sessFac.getCurrentSession().update(ctg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

// private static List<Categories> cats = new ArrayList<>();

// static {
// // first category
//
// Categories ctg = new Categories();
// ctg.setId(1);
// ctg.setName("Graphics Cards");
// ctg.setDesc("Bitchin'");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // second
// ctg = new Categories();
// ctg.setId(2);
// ctg.setName("CPU");
// ctg.setDesc("Heart");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // third
// ctg = new Categories();
// ctg.setId(3);
// ctg.setName("MotherBoard");
// ctg.setDesc("the Mother");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // fourth
// ctg = new Categories();
// ctg.setId(4);
// ctg.setName("Storage");
// ctg.setDesc("Hard stuff");
// ctg.setImageurl("");
// cats.add(ctg);
//
// // third
// ctg = new Categories();
// ctg.setId(5);
// ctg.setName("Memory");
// ctg.setDesc("Stick Stuff");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // sixth
// ctg = new Categories();
// ctg.setId(6);
// ctg.setName("Power Supply Units");
// ctg.setDesc("Power");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // seventh
// ctg = new Categories();
// ctg.setId(7);
// ctg.setName("Cooling Devices");
// ctg.setDesc("Keeping it cool");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // Eighth
// ctg = new Categories();
// ctg.setId(8);
// ctg.setName("Desktop Cases");
// ctg.setDesc("looking sexy");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
// // ninth
// ctg = new Categories();
// ctg.setId(9);
// ctg.setName("Peripherals");
// ctg.setDesc("Power");
// ctg.setImageurl("");
//
// cats.add(ctg);
//
//
// }
