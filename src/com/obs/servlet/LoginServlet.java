package com.obs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obs.model.AdminModel;
import com.obs.model.CustomerModel;
import com.obs.model.EmployeeModel;

import service.UserController;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.contains("admin")) {
			AdminModel adminModel = new AdminModel();
			adminModel.setUsername(username);
			adminModel.setPassword(password);

			UserController u = new UserController();

			try {
				if (u.validateAdmin(adminModel)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("error", "Login Failed Invalid username / password");
					RequestDispatcher rd = request.getRequestDispatcher("login");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (username.contains("emp")) {
			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setEid(username);
			employeeModel.setPassword(password);
			UserController u = new UserController();

			try {
				if (u.validateEmployee(employeeModel)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDashboard");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("error", "Login Failed Invalid username / password");
					RequestDispatcher rd = request.getRequestDispatcher("login");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			CustomerModel customerModel = new CustomerModel();
			customerModel.setAccount_number(Long.parseLong(username));
			customerModel.setPassword(password);
			UserController u = new UserController();

			try {
				if (u.validateCustomer(customerModel)) {
					CustomerModel um = u.getCustomerDetail(customerModel.getAccount_number());
					request.setAttribute("cm", um);
					RequestDispatcher dispatcher = request.getRequestDispatcher("customerDashboard");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("error", "Login Failed Invalid username / password");
					RequestDispatcher rd = request.getRequestDispatcher("login");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
