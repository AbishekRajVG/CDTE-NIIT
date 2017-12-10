package easypc.backend.dao;

import java.util.List;

import easypc.backend.dto.Products;



public interface ProductsDAO {

	List<Products> list();
	Products get(int id);
	//adding category
	boolean add(Products prod);
	boolean update(Products prod);
	boolean delete(Products prod);
	
	//business methods 
	List<Products> listActiveProducts();
	List<Products> listActiveProductsByCategory(int category_id);
	List<Products> getLatestActiveProducts(int count);
	
	
}
