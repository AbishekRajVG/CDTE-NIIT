package easypc.frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import easypc.backend.dao.UsersDAO;
import easypc.backend.dto.Address;
import easypc.backend.dto.Cart;
import easypc.backend.dto.Users;
import easypc.frontend.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel regMod, Users user) {
		regMod.setUser(user);
	}

	public void addBilling(RegisterModel regMod, Address billing) {
		regMod.setBilling(billing);
	}

	public String saveAll(RegisterModel regMod) {

		String transitionVal = "success";

		// getting user
		Users user = regMod.getUser();

		if (user.getRole().equalsIgnoreCase("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);

		}

		//encoding password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		// saving user
		usersDAO.addUser(user);

		// getting addr
		Address billing = regMod.getBilling();

		billing.setUser(user);
		billing.setBilling(true);

		// saving address
		usersDAO.addAddress(billing);

		return transitionVal;
	}

	public String validateUser(Users user, MessageContext error) {
		String transitionVal = "success";

		// checking password missmatch
		if (!(user.getPassword().equals(user.getPassword2()))) {

			error.addMessage(new MessageBuilder().error().source("password2")
					.defaultText("Password Missmatch!! Your clumpsy fingers are at fault..").build());
			transitionVal = "failure";

		}

		// checking for unique email
		if (usersDAO.getByEmail(user.getEmail())!=null){
			
			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Email Already exists").build());
			transitionVal = "failure";
			
		}

			return transitionVal;
	}

}
