package easypc.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dto.Categories;
import easypc.backend.dto.Products;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	
	@Autowired
	private CategoriesDAO catsDAO;

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView manageProducts(){
		ModelAndView mav = new ModelAndView("homepage");
		
		mav.addObject("onManageProducts",true);
		mav.addObject("title","Product Management");
		mav.addObject("status4", "active");
		
		Products newProd = new Products();
		//setting feilds
		newProd.setSupplier_id(1);
		newProd.setActive(true);
		
		mav.addObject("product", newProd);
		
		return mav;
	}
	
	
	//returning categories list
	@ModelAttribute("categories")
	public List<Categories> getCats(){
		
		return catsDAO.list();
	}
}
