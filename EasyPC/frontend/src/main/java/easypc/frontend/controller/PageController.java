package easypc.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Categories;
import easypc.backend.dto.Products;
import easypc.frontend.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger lgr = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoriesDAO catsDAO;
	
	@Autowired
	private ProductsDAO prodDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView test() {
		
		lgr.info("inside Pagecontroller index method - INFO");
		lgr.debug("inside Pagecontroller index method - DEBUG");
		
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "home");
		// passing categories
		mav.addObject("onHome", true);
		mav.addObject("categories", catsDAO.list());
		mav.addObject("status", "active");

		return mav;

	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("onAbout", true);
		mav.addObject("title", "About EasyPC");
		mav.addObject("status1", "active");

		return mav;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("onContact", true);
		mav.addObject("title", "Contact US");
		mav.addObject("status2", "active");

		return mav;

	}

	// mapping for all Products
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAll() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "All Products");
		// passing categories
		mav.addObject("onShowAll", true);
		mav.addObject("categories", catsDAO.list());
		mav.addObject("status3", "active");

		return mav;

	}

	// passing for specific category
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCat(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("homepage");

		// USING CategoriesDAO

		Categories ctg = null;
		ctg = catsDAO.get(id);
	
		
		mav.addObject("title", ctg.getName());
		// passing categories
		mav.addObject("categories", catsDAO.list());
		mav.addObject("Status" + ctg.getId() , "active");
		// passing single category
		mav.addObject("category", ctg);
		mav.addObject("onCat", true);
		return mav;

	}
	
	//mapping for View Product
	@RequestMapping(value={"/show/{id}/product"})
	public ModelAndView viewProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mav = new ModelAndView("homepage");
		
		//getting prod id
		Products prod = prodDAO.get(id);
		
		if(prod==null){throw new ProductNotFoundException();}
		
		//updating view count
		prod.setViews(prod.getViews()+1);
		prodDAO.update(prod);
		
		mav.addObject("title",prod.getName());
		mav.addObject("product", prod);
		mav.addObject("onViewProduct", true);
		
		return mav;
	}

	// @RequestMapping("/test")
	// public ModelAndView test1(@RequestParam(value = "msg", required = false)
	// String msg) {
	// if (msg.equals(null)) {
	// msg = "Welcome Message";
	// }
	// ModelAndView mav = new ModelAndView("homepage");
	// mav.addObject("hello", msg);
	// return mav;
	// }
	//
	// @RequestMapping("/tests/{msg}")
	// public ModelAndView test2(@PathVariable("msg") String msg) {
	// if (msg.equals(null)) {
	// msg = "Welcome Message";
	// }
	// ModelAndView mav = new ModelAndView("homepage");
	// mav.addObject("hello", msg);
	// return mav;
	// }

}
