package easypc.frontend.model;

import java.io.Serializable;

import easypc.backend.dto.Address;
import easypc.backend.dto.Users;

public class RegisterModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;
	private Address billing;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

}
