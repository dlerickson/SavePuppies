package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adopter;
import model.AdoptionDetails;
import model.ListPuppers;

/**
 * Servlet implementation class createNewAdoptionServlet
 */
@WebServlet("/createNewAdoptionServlet")
public class createNewAdoptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewAdoptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPuppersHelper lph = new ListPuppersHelper();
		String coordinatorName = request.getParameter("coordinatorName");

		System.out.println("Coordinator Name: " + coordinatorName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String adopterName = request.getParameter("adopterName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ListPuppers> selectedItemsInList = new ArrayList<ListPuppers>();
		// if nothing is selected we will get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListPuppers c = lph.searchForPupById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}

		Adopter adopter = new Adopter(adopterName);
		AdoptionDetails sld = new AdoptionDetails(coordinatorName, ld, adopter);
		sld.setListOfPups(selectedItemsInList);
		AdoptionDetailsHelper slh = new AdoptionDetailsHelper();
		slh.insertNewAdoptionDetails(sld);

		System.out.println("Woohoo!");
		System.out.println(sld.toString());

		getServletContext().getRequestDispatcher("/viewAllAdoptionsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}
