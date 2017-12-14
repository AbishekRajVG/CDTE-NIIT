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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name = "operation", required = false) String op) {
		ModelAndView mav = new ModelAndView("homepage");

		mav.addObject("onManageProducts", true);
		mav.addObject("title", "Product Management");
		mav.addObject("cardTitle", "add new Product");
		mav.addObject("status4", "active");
		mav.addObject("submitbutton", "Add product");

		Products newProd = new Products();
		// setting feilds
		newProd.setSupplier_id(1);
		newProd.setActive(true);

		mav.addObject("product", newProd);

		if (op != null) {

			if (op.equals("product")) {
				mav.addObject("msg", "Product Added Succesfully");
				mav.addObject("alertcolor", "alert-success");

			} else if (op.equals("editproduct")) {
				mav.addObject("msg", "Product edited Succesfully");
				mav.addObject("alertcolor", "alert-success");

			} else if (op.equals("category")) {
				mav.addObject("msg", "Category Added Succesfully");
				mav.addObject("alertcolor", "alert-success");
			}

		}

		return mav;
	}

	// edit product
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView EditProduct(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("homepage");

		Products editProd = prodDAO.get(id);

		mav.addObject("onManageProducts", true);
		mav.addObject("title", "Product Management");
		mav.addObject("cardTitle", "edit, Product id : " + editProd.getCode().toString());
		mav.addObject("status4", "active");
		mav.addObject("submitbutton", "Edit product");

		mav.addObject("product", editProd);

		return mav;
	}

	// product add
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String addProd(@Valid @ModelAttribute("product") Products modProd, BindingResult bindRes, Model model,
			HttpServletRequest req) {

		String op = "";
		if (modProd.getId() == 0) {
			new ProdValidator().validate(modProd, bindRes);
			op = "product";
		} else {
			op = "editproduct";
			if (!modProd.getFile().getOriginalFilename().equals("")) {
				new ProdValidator().validate(modProd, bindRes);

			}
		}
		// catching errors
		if (bindRes.hasErrors()) {

			model.addAttribute("title", "Product Management");
			model.addAttribute("onManageProducts", true);
			model.addAttribute("msg", "Product Submission has failed!");
			model.addAttribute("alertcolor", "alert-danger");
			model.addAttribute("submitbutton", "Add product");

			return "homepage";
		}

		// logging product details
		lgr.info(modProd.toString());

		if (modProd.getId() == 0)
			// create new product
			prodDAO.add(modProd);
		else
			// update existing product
			prodDAO.update(modProd);

		if (!modProd.getFile().getOriginalFilename().equals("")) {
			FileUploader.uploadFile(req, modProd.getFile(), modProd.getCode());
		}

		return "redirect:/manage/products?operation=" + op;
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public void ActivateProd(@PathVariable int id) {

		// finding product in the DB
		Products prod = prodDAO.get(id);

		// activation/deactivation
		prod.setActive(!(prod.isActive()));

		prodDAO.update(prod);

	}

	// add category
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String addnewCat(@ModelAttribute("category") Categories category) {

		catsDAO.add(category);

		return "redirect:/manage/products?operation=category";
	}

	// returning categories list
	@ModelAttribute("categories")
	public List<Categories> getCats() {

		return catsDAO.list();
	}

	@ModelAttribute("category")
	public Categories getCat() {
		return new Categories();

	}

}
