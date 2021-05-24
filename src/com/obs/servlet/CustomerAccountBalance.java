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
 * Servlet implementation class CustomerAccountBalance
 */
@WebServlet("/CustomerAccountBalance")
public class CustomerAccountBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccountBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acno = request.getParameter("acno");
		UserController uc = new UserController();
		CustomerModel um = uc.getCustomerDetail(Long.parseLong(acno));

		request.setAttribute("cm", um);
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountBalance");
		dispatcher.forward(request, response);
	}

}
