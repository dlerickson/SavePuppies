import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.AdopterHelper;
import controller.AdoptionDetailsHelper;
import model.Adopter;
import model.AdoptionDetails;
import model.ListPuppers;

public class AdoptingTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Adopter don = new Adopter("Don");
		
		AdopterHelper ah = new AdopterHelper();
		
		ah.insertAdopter(don);
		
		List<Adopter> allAdopters = ah.showAllAdopters();
		for(Adopter a: allAdopters) {
			System.out.println(a.toString());
		}
		*/
		
		Adopter svp = new Adopter("SVP");
		
		AdoptionDetailsHelper adh = new AdoptionDetailsHelper();
		
		ListPuppers otis = new ListPuppers("Otis", "Kong", "Adopted");
		
		List<ListPuppers> svpPuppers = new ArrayList<ListPuppers>();
		svpPuppers.add(otis);

		
		AdoptionDetails svpList = new AdoptionDetails("SVP's Adoption", LocalDate.now(), svp);
		svpList.setListOfPups(svpPuppers);
		
		adh.insertNewAdoptionDetails(svpList);
		
		List<AdoptionDetails> allDetails = adh.getAdoptions();
		for(AdoptionDetails a: allDetails) {
			System.out.println(a.toString());
		}
	}

}
