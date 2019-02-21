package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdoptionDetails;

/**
 * Servlet implementation class viewAllAdoptionsServlet
 */
@WebServlet("/viewAllAdoptionsServlet")
public class viewAllAdoptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllAdoptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		AdoptionDetailsHelper adh = new AdoptionDetailsHelper();
		List<AdoptionDetails> abc = adh.getAdoptions();
		request.setAttribute("allAdoptions", abc);
		
		if(abc.isEmpty()) {
			request.setAttribute("allAdoptions", " ");
		}
		
		getServletContext().getRequestDispatcher("/adoptions-by-adopter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
