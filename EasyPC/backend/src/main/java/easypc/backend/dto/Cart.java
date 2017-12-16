package easypc.backend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//one to one mapping b/w user and cart
	@OneToOne
	private Users user;
	
	private double grand_total;
	private int cart_lines;

	@Override
	public String toString() {
		return "Cart [id=" + id + ", grand_total=" + grand_total + ", cart_lines=" + cart_lines + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}

	public int getCart_lines() {
		return cart_lines;
	}

	public void setCart_lines(int cart_lines) {
		this.cart_lines = cart_lines;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	

}
