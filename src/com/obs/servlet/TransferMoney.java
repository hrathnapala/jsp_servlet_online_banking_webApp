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
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
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
		
		try {
		String acno = request.getParameter("acno");
		String accountbalance = request.getParameter("accountbalance");
		String acno1 = request.getParameter("acno1");
		String amount = request.getParameter("amount");
		
		UserController uc = new UserController();
		CustomerModel um = uc.getCustomerDetail(Long.parseLong(acno1));
		CustomerModel um1 = uc.getCustomerDetail(Long.parseLong(acno));
		
		
		 
		
		if(um == null || um1 == null) {
			request.setAttribute("cm", um1);
			request.setAttribute("error", "Transfer Failed");
			RequestDispatcher rd = request.getRequestDispatcher("transferMoney");
			rd.include(request, response);
		}else {
			um.setAccount_balance(um.getAccount_balance() + Double.parseDouble(amount));
			um1.setAccount_balance(um1.getAccount_balance() - Double.parseDouble(amount));
			uc.updateCustomer(um1, acno);
			uc.updateCustomer(um, acno1);
			request.setAttribute("cm", um1);
			request.setAttribute("error", "Success");
			RequestDispatcher rd = request.getRequestDispatcher("transferMoney");
			rd.include(request, response);
		}
		}catch (Exception e) {
			String acno = request.getParameter("acno");
			UserController uc = new UserController();
			CustomerModel um = uc.getCustomerDetail(Long.parseLong(acno));
			request.setAttribute("cm", um);
			request.setAttribute("error", "Invalid Details");
			RequestDispatcher rd = request.getRequestDispatcher("transferMoney");
			rd.include(request, response);
		}

	}

}
