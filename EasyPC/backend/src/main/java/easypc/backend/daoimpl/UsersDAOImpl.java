package easypc.backend.daoimpl;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import easypc.backend.dao.UsersDAO;
import easypc.backend.dto.Address;
import easypc.backend.dto.Cart;
import easypc.backend.dto.Users;

@Repository("usersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private SessionFactory sessFac;

	@Override
	public boolean addUser(Users user) {
		try {
			sessFac.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address addr) {
		try {
			sessFac.getCurrentSession().persist(addr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessFac.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Users getByEmail(String email) {
		String selectQuery = "FROM Users WHERE email =:email";

		try {

			return sessFac.getCurrentSession().createQuery(selectQuery, Users.class).setParameter("email", email)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Address getBillingAddress(Users user) {
		String query = "FROM Address WHERE user = :user AND billing =:billing";

		try {

			return sessFac.getCurrentSession().createQuery(query, Address.class).setParameter("user", user)
					.setParameter("billing", true).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Address> getShippingAddresses(Users user) {
		
		String query = "FROM Address WHERE user = :user AND shipping =:shipping";

		try {

			return sessFac.getCurrentSession().createQuery(query, Address.class).setParameter("user", user)
					.setParameter("shipping", true).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
