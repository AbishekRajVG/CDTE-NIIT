package easypc.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import easypc.backend.dao.CategoriesDAO;
import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Categories;
import easypc.backend.dto.Products;
import easypc.frontend.util.FileUploader;
import easypc.frontend.validator.ProdValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	
	@Autowired
	private CategoriesDAO catsDAO;
	
	@Autowired
	private ProductsDAO prodDAO;
	 
	private static final Logger lgr = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name="operation",required=false) String op){
		ModelAndView mav = new ModelAndView("homepage");
		
		mav.addObject("onManageProducts",true);
		mav.addObject("title","Product Management");
		mav.addObject("status4", "active");
		
		Products newProd = new Products();
		//setting feilds
		newProd.setSupplier_id(1);
		newProd.setActive(true);
		
		mav.addObject("product", newProd);
		
		if(op!=null){
			
			if(op.equals("product")){
				mav.addObject("msg", "Product Added Succesfully");
				mav.addObject("alertcolor","alert-success");
			}
			
		}
		
		return mav;
	}
	
	
	//product add
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProd(@Valid @ModelAttribute("product") Products modProd, BindingResult bindRes, Model model, HttpServletRequest req){
		
		new ProdValidator().validate(modProd, bindRes);
		
		
		
		//catching errors
		if(bindRes.hasErrors()){
			
			model.addAttribute("title","Product Management");
			model.addAttribute("onManageProducts",true);
			model.addAttribute("msg","Product Submission has failed!");
			model.addAttribute("alertcolor","alert-danger");
			
			return "homepage";
		}
		
		
		//logging product details
		lgr.info(modProd.toString());
		
		prodDAO.add(modProd);
		
		if(!modProd.getFile().getOriginalFilename().equals("")){
			FileUploader.uploadFile(req,modProd.getFile(),modProd.getCode());
		}
		
		return "redirect:/manage/products?operation=product";	
	}
	
	
	
	
	//returning categories list
	@ModelAttribute("categories")
	public List<Categories> getCats(){
		
		return catsDAO.list();
	}
		
	
}
