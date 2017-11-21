package easypc.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class PageController {


	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "home");
		mav.addObject("onHome", true);
	
		return mav;
	
	
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "About EasyPC");
		mav.addObject("onAbout", true);
		return mav;
	}
	
	@RequestMapping(value = {"/contact" })
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("title", "Contact US");
		mav.addObject("onContact", true);
		return mav;
	
	
	}
	
//	@RequestMapping("/test")
//	public ModelAndView test1(@RequestParam(value = "msg", required = false) String msg) {
//		if (msg.equals(null)) {
//			msg = "Welcome Message";
//		}
//		ModelAndView mav = new ModelAndView("homepage");
//		mav.addObject("hello", msg);
//		return mav;
//	}
//
//	@RequestMapping("/tests/{msg}")
//	public ModelAndView test2(@PathVariable("msg") String msg) {
//		if (msg.equals(null)) {
//			msg = "Welcome Message";
//		}
//		ModelAndView mav = new ModelAndView("homepage");
//		mav.addObject("hello", msg);
//		return mav;
//	}




}
