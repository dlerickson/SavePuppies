package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_details")
public class AdoptionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//these are the deets of the adoption
	@Column(name = "ADOPTION_ID")
	private int id;
	@Column(name = "COORDINATOR_NAME")
	private String coordinatorName;
	@Column(name = "ADOPTION_DATE")
	private LocalDate adoptionDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "ADOPTER_ID")
	private Adopter adopter;

	public AdoptionDetails() {
		super();
	}

	public AdoptionDetails(int id, String coordinatorName, LocalDate adoptionDate, Adopter adopter,
			List<ListPuppers> listOfPups) {
		super();
		this.id = id;
		this.coordinatorName = coordinatorName;
		this.adoptionDate = adoptionDate;
		this.adopter = adopter;
		this.listOfPups = listOfPups;
	}

	public AdoptionDetails(String coordinatorName, LocalDate adoptionDate, Adopter adopter,
			List<ListPuppers> listOfPups) {
		super();
		this.coordinatorName = coordinatorName;
		this.adoptionDate = adoptionDate;
		this.adopter = adopter;
		this.listOfPups = listOfPups;
	}

	public AdoptionDetails(String coordinatorName, LocalDate adoptionDate, Adopter adopter) {
		super();
		this.coordinatorName = coordinatorName;
		this.adoptionDate = adoptionDate;
		this.adopter = adopter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public LocalDate getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(LocalDate adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public List<ListPuppers> getListOfPups() {
		return listOfPups;
	}

	public void setListOfPups(List<ListPuppers> listOfPups) {
		this.listOfPups = listOfPups;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "ADOPTED_LIST",
		joinColumns = {
			@JoinColumn(name = "LIST_ID", referencedColumnName = "ADOPTION_ID") },
		inverseJoinColumns = {
			@JoinColumn(name = "ADOPTED_ID", referencedColumnName = "ID", unique = true) })
	private List<ListPuppers> listOfPups;

}
