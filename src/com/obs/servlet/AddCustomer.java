package com.obs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obs.model.CustomerModel;

import service.UserController;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomer() {
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
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String accountnumber = request.getParameter("accountnumber");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String account_balance = request.getParameter("accountbalance");
		boolean status = request.getParameter("status") == null ? false : true;
		String password = request.getParameter("password");

		CustomerModel user = new CustomerModel(name, Long.parseLong(accountnumber), nic, email, address,
				Integer.parseInt(phonenumber), Double.parseDouble(account_balance), status, password);

		UserController h = new UserController();
		h.addCustomer(user);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDashboard");
		dispatcher.forward(request, response);
		
	}

}
