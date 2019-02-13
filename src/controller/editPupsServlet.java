package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPuppers;

/**
 * Servlet implementation class editPupsServlet
 */
@WebServlet("/editPupsServlet")
public class editPupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editPupsServlet() {
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

		String name = request.getParameter("name");
		String favToy = request.getParameter("favToy");
		String status = request.getParameter("status");
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		ListPuppers pupDate = dao.searchForPupById(tempId);
		pupDate.setName(name);
		pupDate.setFavToy(favToy);
		pupDate.setStatus(status);

		dao.updateGoodDoggie(pupDate);

		getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);

	}

}
