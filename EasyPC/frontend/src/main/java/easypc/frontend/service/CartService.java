package easypc.frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easypc.backend.dao.CartLineDAO;
import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Cart;
import easypc.backend.dto.CartLine;
import easypc.backend.dto.Products;
import easypc.frontend.model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession sess;

	@Autowired
	private ProductsDAO prodDAO;

	// linking cart to logged in user
	private Cart getCart() {

		return ((UserModel) sess.getAttribute("userModel")).getCart();
	}

	// returns cart line
	public List<CartLine> getCartLines() {
		return cartLineDAO.list(this.getCart().getId());
	}

	public String updateCartLine(int cartLineId, int count) {

		// getting cartline using id
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null) {
			return "result=error";
		} else {

			Products prod = cartLine.getProduct();

			double oldTotal = cartLine.getTotal();
			if (prod.getQuantity() <= count) {
				count = prod.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(prod.getUnit_price());

			cartLine.setTotal(prod.getUnit_price() * count);
			cartLineDAO.update(cartLine);

			Cart cart = this.getCart();
			cart.setGrand_total(cart.getGrand_total() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);

			return "result=updated";

		}

	}

	public String removeCartLine(int cartLineId) {

		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null)
			return "result=error";
		else {
			// update cart
			Cart cart = this.getCart();
			cart.setGrand_total(cart.getGrand_total() - cartLine.getTotal());
			cart.setCart_lines(cart.getCart_lines() - 1);
			cartLineDAO.updateCart(cart);
			// remove cartLine
			cartLineDAO.delete(cartLine);
			return "result=deleted";

		}
	}

	public String addCartLine(int productId) {

		String res = null;
		// session's cart
		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		if (cartLine == null) {
			cartLine = new CartLine();
			Products prod = prodDAO.get(productId);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(prod);
			cartLine.setBuyingPrice(prod.getUnit_price());
			cartLine.setProductCount(1);
			cartLine.setTotal(prod.getUnit_price());
			cartLine.setAvailable(true);

			cartLineDAO.add(cartLine);

			cart.setCart_lines(cart.getCart_lines() + 1);
			cart.setGrand_total(cart.getGrand_total() + cartLine.getTotal());

			cartLineDAO.updateCart(cart);

			res = "response=added";

		}

		return res;
	}

	public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineDAO.list(cart.getId());
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Products product = null;
		for (CartLine cartLine : cartLines) {
			product = cartLine.getProduct();
			changed = false;
			
			if ((!product.isActive() && product.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}

			if ((product.isActive() && product.getQuantity() > 0) && !(cartLine.isAvailable())) {
				cartLine.setAvailable(true);
				changed = true;
			}

			if (cartLine.getBuyingPrice() != product.getUnit_price()) {
				cartLine.setBuyingPrice(product.getUnit_price());
				cartLine.setTotal(cartLine.getProductCount() * product.getUnit_price());
				changed = true;
			}

			// check if that much quantity of product is available or not
			if (cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());
				cartLine.setTotal(cartLine.getProductCount() * product.getUnit_price());
				changed = true;

			}

			// changes has happened
			if (changed) {
				// update the cartLine
				cartLineDAO.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}

			grandTotal += cartLine.getTotal();
			lineCount++;
		}

		cart.setCart_lines(lineCount++);
		cart.setGrand_total(grandTotal);
		cartLineDAO.updateCart(cart);

		return response;
	}
}
