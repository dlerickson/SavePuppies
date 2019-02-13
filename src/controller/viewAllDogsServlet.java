package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllDogsServlet
 */
@WebServlet("/viewAllDogsServlet")
public class viewAllDogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllDogsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPuppersHelper dao = new ListPuppersHelper();
		//using helper methods to get list of all the doggos
		request.setAttribute("allDogs", dao.showMeThePuppy());
		//if there were no pups...
		if(dao.showMeThePuppy().isEmpty()) {
			request.setAttribute("allDogs", "This is not correct, Don");
		}
		//where we go when we want to see the good dogs
		getServletContext().getRequestDispatcher("/doggie-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
