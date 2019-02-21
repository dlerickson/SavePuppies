package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adopter")
public class Adopter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADOPTER_ID")
	private int id;
	@Column(name = "ADOPTER_NAME")
	private String adopterName;

	public Adopter() {
		super();
	}

	public Adopter(int id, String adopterName) {
		super();
		this.id = id;
		this.adopterName = adopterName;
	}
	
	public Adopter(String adopterName) {
		super();
		this.adopterName = adopterName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdopterName() {
		return adopterName;
	}

	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}

	@Override
	public String toString() {
		return "Adopter [id=" + id + ", adopterName=" + adopterName + "]";
	}

}
