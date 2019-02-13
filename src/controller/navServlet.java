package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPuppers;

/**
 * Servlet implementation class navServlet
 */
@WebServlet("/navServlet")
public class navServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public navServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		ListPuppersHelper dao = new ListPuppersHelper();
		String act = request.getParameter("doThisToDog");

		if (act == null) {
			// if no puppy in doggie list was selected then do this
			getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			// did someone else foster the pup? if yes, delete the pup info
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListPuppers pupToDelete = dao.searchForPupById(tempId);
				dao.deletePups(pupToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to choose a pup");

			} finally {
				getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			// made an oops on spelling or hopefully a pup's status is updated to adopted
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListPuppers pupToEdit = dao.searchForPupById(tempId);
				request.setAttribute("pupToEdit", pupToEdit);
				getServletContext().getRequestDispatcher("/edit-pups.jsp").forward(request, response);

			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);

			}
			
		} else if (act.equals("add")) {
			// yay for fostering another doggo
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}

	}

}
