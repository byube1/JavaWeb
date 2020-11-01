package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dto.item;

/**
 * Servlet implementation class formForEdit
 */
@WebServlet("/formForEdit")
public class formForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formForEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("ID");
		String Name = request.getParameter("Name");
		String Description = request.getParameter("Desc");
		float Price = Float.parseFloat(request.getParameter("Price"));
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		String URL = request.getParameter("IMG");
		
		item packageItem = new item(ID, Name, Description, Quantity, Price, URL);
		HttpSession sesstion = request.getSession();
		sesstion.setAttribute("packItem", packageItem);
		response.sendRedirect("form.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
