package easypc.backend.dao;

import java.util.List;

import easypc.backend.dto.Categories;

public interface CategoriesDAO {

	List<Categories> list();
	Categories get(int id);
}
