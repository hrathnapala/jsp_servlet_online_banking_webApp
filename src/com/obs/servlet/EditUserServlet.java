package com.obs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obs.model.UserModel;

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

		UserModel um = new UserModel();
		um.setId(Integer.parseInt(request.getParameter("id")));
		um.setName(request.getParameter("name"));
		um.setEmail(request.getParameter("email"));
		um.setCountry(request.getParameter("country"));

		UserController cs = new UserController();

		cs.updateUser(um, request.getParameter("id"));

		int status = cs.updateUser(um, request.getParameter("id"));

		if (status < 1) {
			request.setAttribute("error", "Update Failed");
			RequestDispatcher rd = request.getRequestDispatcher("edituserForm");
			rd.include(request, response);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage");
		dispatcher.forward(request, response);

	}

}
