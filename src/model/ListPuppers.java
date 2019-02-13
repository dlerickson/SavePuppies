package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "puppies")
public class ListPuppers {
//Don Erickson

	// instance puppiables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private String status;
	@Column(name = "favtoy")
	private String favToy;

	// default no bark constructor
	public ListPuppers() {
		super();
	}

	// fetchers and setters
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFavToy() {
		return favToy;
	}

	public void setFavToy(String favToy) {
		this.favToy = favToy;
	}

	// this constructor is full of barks
	public ListPuppers(String name, String favToy, String status) {
		super();
		this.name = name;
		this.favToy = favToy;
		this.status = status;
	}

	/*
	 * save for later. this is to only take a pups name to delete the entire row...
	 * public ListPuppers(String name) {
	 *
	 * // TODO Auto-generated constructor stub}
	 *
	 *
	 */
	
	@Override
	public String toString() {
		return "ListPuppers []";
	}
	

	// print the puppy deets
	public String returnPupInfo() {
		return name + "'s favorite toy is the " + favToy + ". This pups's availability: " + status + ".";
	}

}
