package easypc.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import eacypc.backend.dao.CategoriesDAO;

@Controller
public class PageController {

	
	private CategoriesDAO catsDAO;

	@Autowired(required = true)
//	@Qualifier(value="catsDAO")
	public void setCategoriesDAO(CategoriesDAO ctgDAO) {
		this.catsDAO = ctgDAO;
	}

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "home");
		mav.addObject("onHome", true);

		// passing categories
		mav.addObject("categories", catsDAO.list());

		return mav;

	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "About EasyPC");
		mav.addObject("onAbout", true);
		return mav;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "Contact US");
		mav.addObject("onContact", true);
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
