package com.obs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obs.model.AdminModel;

import service.AdminController;

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
		AdminModel adminModel = new AdminModel();
		adminModel.setUsername(username);
		adminModel.setPassword(password);

		try {
			if (AdminController.validate(adminModel)) {
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
	}

}
