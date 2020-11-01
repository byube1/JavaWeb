package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dto.item;
import valiation.check;

/**
 * Servlet implementation class CRUDservlet
 */
@WebServlet(urlPatterns = { "/CRUDservlet", "/CRUDservlet/add", "/CRUDservlet/edit", "/CRUDservlet/delete" })
public class CRUDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDservlet() {
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
		String action = request.getServletPath();
		

		switch (action) {
		case "/CRUDservlet/delete": {
			deleteProduct(request, response);
			break;
		}
		case "/CRUDservlet/add":{
			AddProduct(request, response);
			break;
		}
		case "/CRUDservlet/edit":{
			EditProduct(request, response);
			break;
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ID = request.getParameter("ID");
		HttpSession session = request.getSession();
		try {
			ProductDAO.deleteItem(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<item> listItem = ProductDAO.getProduct();
			session.setAttribute("listItem", listItem);
			response.sendRedirect("/CRUDfilter/main.jsp");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
	}
	
	protected void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> Error = new ArrayList<String>();
		String ID = request.getParameter("IDProduct");
		String Name = request.getParameter("Name");
		String Description = request.getParameter("Description");
		float Price = Float.parseFloat(request.getParameter("Price"));
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		String URL = request.getParameter("URL");
		
		HttpSession session = request.getSession();
		if(!check.checkID(ID)) {
			Error.add("Check Your ID");
			session.setAttribute("Error", Error);
			response.sendRedirect("/CRUDfilter/form.jsp");	
			return;
		}
		
		try {
			ProductDAO.addItem(ID, Name, Description, URL, Price, Quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<item> listItem = ProductDAO.getProduct();
			session.setAttribute("listItem", listItem);
			response.sendRedirect("/CRUDfilter/main.jsp");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	protected void EditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String ID = request.getParameter("ID");
		String Name = request.getParameter("Name");
		String Description = request.getParameter("Description");
		float Price = Float.parseFloat(request.getParameter("Price"));
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		String URL = request.getParameter("URL");
		HttpSession session = request.getSession();
		System.out.println(ID);
		try {
			ProductDAO.updateProduct(ID, Name, Description, URL, Price, Quantity);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			ArrayList<item> listItem = ProductDAO.getProduct();
			session.setAttribute("listItem", listItem);
			response.sendRedirect("/CRUDfilter/main.jsp");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
