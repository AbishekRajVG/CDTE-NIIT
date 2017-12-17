package easypc.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import easypc.backend.dao.UsersDAO;
import easypc.backend.dto.Users;
import easypc.frontend.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UsersDAO usersDAO;
	
	private UserModel userMod = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {	

		if (session.getAttribute("userModel") == null) {
			
			//adding user model
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			Users user=  usersDAO.getByEmail(auth.getName());
			
			if(user!=null){
				
				//creating new user model
				userMod = new UserModel();
				userMod.setId(user.getId());
				userMod.setEmail(user.getEmail());
				userMod.setRole(user.getRole());
				userMod.setFullname(user.getFirst_name()+" "+user.getLast_name());
				
				if(userMod.getRole().equalsIgnoreCase("USER")){
					
					userMod.setCart(user.getCart());
					
				}
				
				//setting user model in session
				session.setAttribute("userModel", userMod);
				
				return userMod;
			}
			
			
		}

		return (UserModel) session.getAttribute("userModel");
		
	}

}
