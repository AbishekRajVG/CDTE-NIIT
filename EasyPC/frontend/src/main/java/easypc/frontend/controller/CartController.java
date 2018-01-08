package easypc.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import easypc.frontend.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private final static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
	
		ModelAndView mv = new ModelAndView("homepage");
		mv.addObject("title", "Shopping Cart");
		mv.addObject("onCart", true);

		if (result != null) {
			switch (result) {

			case "added":
				mv.addObject("message", "Product, added to cart !");
				break;
			case "updated":
				mv.addObject("message", "Cart has been updated successfully!");
				break;
			case "deleted":
				mv.addObject("message", "Product has been removed!");
				break;
			case "error":
				mv.addObject("message", "Something went wrong !!");
				break;
			
			}
		}
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;

	}

	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable int cartLineId, @RequestParam int count) {
		String res = cartService.updateCartLine(cartLineId, count);
		return "redirect:/cart/show?" + res;
	}

	
	 @RequestMapping("/add/{productId}/product")
	 public String addCartLine(@PathVariable int productId) {
	 String response = cartService.addCartLine(productId);
	 return "redirect:/cart/show?"+response;
	 }
	
	@RequestMapping("/{cartLineId}/delete")
	public String removeCartLine(@PathVariable int cartLineId) {
		String response = cartService.removeCartLine(cartLineId);
		return "redirect:/cart/show?" + response;
	}
	
	
	
	 @RequestMapping("/validate")
	 public String validateCart() {
	 String res = cartService.validateCartLine();
	 if(!res.equals("result=success")) {
	 return "redirect:/cart/show?"+res;
	 }
	 else {
	 return "redirect:/cart/checkout";
	 }
	 }
}
