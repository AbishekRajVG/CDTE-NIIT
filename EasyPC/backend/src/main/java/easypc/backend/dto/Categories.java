package easypc.backend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {

	
	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", desc=" + desc + ", imageurl=" + imageurl + ", active="
				+ active + "]";
	}

	// private data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String desc;
	private String imageurl;
	private boolean active = true;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageURL) {
		this.imageurl = imageURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
