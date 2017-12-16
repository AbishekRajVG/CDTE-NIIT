package easypc.backend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//many to one 
	@ManyToOne
	private Users user;
	@NotBlank(message="Please enter an Adress")
	private String address_line_one;
	private String address_line_two;
	@NotBlank(message="Please enter the city name")
	private String city;
	@NotBlank(message="Please enter the State name")
	private String state;
	@NotBlank(message="Please enter the country name")
	private String country;
	@NotBlank(message="Please enter the Postal Code")
	private String postal_code;
	private boolean shipping;
	private boolean billing;

	@Override
	public String toString() {
		return "Adress [id=" + id + ", address_line_one=" + address_line_one
				+ ", address_line_two=" + address_line_two + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postal_code=" + postal_code + ", shipping=" + shipping + ", billing=" + billing + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddress_line_one() {
		return address_line_one;
	}

	public void setAddress_line_one(String address_line_one) {
		this.address_line_one = address_line_one;
	}

	public String getAddress_line_two() {
		return address_line_two;
	}

	public void setAddress_line_two(String address_line_two) {
		this.address_line_two = address_line_two;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
	

}
