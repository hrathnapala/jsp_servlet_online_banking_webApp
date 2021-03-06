package com.obs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obs.model.EmployeeModel;

import service.UserController;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
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

		String eid = request.getParameter("eid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String nic = request.getParameter("nic");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");

		EmployeeModel user = new EmployeeModel(eid, name, email, address, phonenumber, password, nic);

		UserController h = new UserController();
		h.addEmployee(user);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage");
		dispatcher.forward(request, response);
	}

}
