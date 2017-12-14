package easypc.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Products;
//yolo321
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductsDAO prodDAO;

	@RequestMapping("/show/all/products")
	@ResponseBody
	public List<Products> getAllProducts() {
		
		return prodDAO.listActiveProducts();

	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Products> getAllProductsAdmin() {
		
		return prodDAO.list();

	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Products> getProductsByCategory(@PathVariable int id) {
		
		return prodDAO.listActiveProductsByCategory(id);

	}
	
	
	
}
