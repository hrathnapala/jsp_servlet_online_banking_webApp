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
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserServlet() {
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
		
		String eid = request.getParameter("eid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String nic = request.getParameter("nic");

		EmployeeModel um = new EmployeeModel(eid, name, email, address, phonenumber, password, nic);

		UserController cs = new UserController();
		
		int status = cs.updateEmployee(um, eid);

		if (status < 1) {
			request.setAttribute("error", "Update Failed");
			RequestDispatcher rd = request.getRequestDispatcher("edituserForm");
			rd.include(request, response);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage");
		dispatcher.forward(request, response);

	}

}
