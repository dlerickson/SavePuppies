import java.util.List;
import java.util.Scanner;

import controller.ListPuppersHelper;
import model.ListPuppers;

public class StartPupProgram {

	static Scanner in = new Scanner(System.in);
	static ListPuppersHelper lph = new ListPuppersHelper();

	private static void addPups() {
		// TODO Auto-generated method stub
		System.out.print("Puppy name: ");
		String name = in.nextLine();
		System.out.print("Favorite toy: ");
		String favToy = in.nextLine();
		System.out.print("Availability: ");
		String status = in.nextLine();
		ListPuppers toAdd = new ListPuppers(name, favToy, status); // usin tha bark constructor
		lph.fosterPups(toAdd); // helper method playing tug

	}

	private static void deletePups() {
		// TODO Auto-generated method stub
		System.out.print("Pupper name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter toy to delete: ");
		String favToy = in.nextLine();
		System.out.print("Doggie status to delete: ");
		String status = in.nextLine();
		ListPuppers toDelete = new ListPuppers(name, favToy, status);
		lph.deletePups(toDelete);

	}

	private static void editPups() {
		// TODO Auto-generated method stub
		System.out.println("Find your next pup! ");
		System.out.println("Enter: 1 -to call by name.");
		System.out.println("Enter: 2 -to search by status.");
		int searchBy = in.nextInt();
		in.nextLine();

		List<ListPuppers> foundPups;
		if (searchBy == 1) {
			System.out.print("Enter the good boy's name: ");
			String dogName = in.nextLine();
			foundPups = lph.searchForPupByName(dogName);

		} else {
			System.out.print("Enter current status: ");
			String dogStatus = in.nextLine();
			foundPups = lph.searchForPupByStatus(dogStatus);

		}

		if (!foundPups.isEmpty()) {
			System.out.println("Found Results.");
			for (ListPuppers l : foundPups) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListPuppers toEdit = lph.searchForPupById(idToEdit);
			System.out.println("Fetched " + toEdit.getName() + " with the status of: " + toEdit.getStatus());
			System.out.println("Enter: 1 -Update Status");
			System.out.println("Enter: 2 -Update Toy");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Status: ");
				String newStatus = in.nextLine();
				toEdit.setStatus(newStatus);
			} else if (update == 2) {
				System.out.print("New Best Toy: ");
				String newToy = in.nextLine();
				toEdit.setFavToy(newToy);
			}

			lph.updateGoodDoggie(toEdit);

		} else {
			System.out.println("---- No dogs found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Editable list of pups we've saved. Enter number from the menu. ---");
		while (goAgain) {
			System.out.println("");
			System.out.println("*  Pawsitively Pawesome Puppies:");
			System.out.println("*  1 -- Add a good dog");
			System.out.println("*  2 -- Edit doggo info");
			System.out.println("*  3 -- Delete puppy profile");
			System.out.println("*  4 -- View all best frans");
			System.out.println("*  5 -- Exit after giving pets");
			System.out.print("*  Your selection number: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPups();
			} else if (selection == 2) {
				editPups();
			} else if (selection == 3) {
				deletePups();
			} else if (selection == 4) {
				viewPups();
			} else {
				lph.cleanUp();
				System.out.println("   Woof!   ");
				goAgain = false;
			}

		}

	}

	// use that list we created in the helper class
	private static void viewPups() {
		// TODO Auto-generated method stub
		List<ListPuppers> thePuppies = lph.showMeThePuppy();
		for (ListPuppers singlePup : thePuppies) {
			System.out.println(singlePup.returnPupInfo());
		}

	}

}