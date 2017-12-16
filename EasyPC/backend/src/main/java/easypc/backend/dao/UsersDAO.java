package easypc.backend.dao;

import java.util.List;

import easypc.backend.dto.Address;
import easypc.backend.dto.Cart;
import easypc.backend.dto.Users;

public interface UsersDAO {

	boolean addUser(Users user);
	Users getByEmail(String email);
	
	boolean addAddress(Address addr);
	Address getBillingAddress(Users user);
	List<Address> getShippingAddresses(Users user);
		
	boolean updateCart(Cart cart);
}
