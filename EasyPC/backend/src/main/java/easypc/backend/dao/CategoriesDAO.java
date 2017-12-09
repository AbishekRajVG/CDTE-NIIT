package easypc.backend.dao;

import java.util.List;

import easypc.backend.dto.Categories;

public interface CategoriesDAO {

	List<Categories> list();
	Categories get(int id);
	//adding category
	boolean add(Categories ctg);
	boolean update(Categories ctg);
	boolean delete(Categories ctg);
}
