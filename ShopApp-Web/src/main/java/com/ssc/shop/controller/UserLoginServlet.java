package com.ssc.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssc.shop.dao.UserDao;
import com.ssc.shop.dao.UserDaoImpl;
import com.ssc.shop.model.UserInfo;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(name = "userlogin", urlPatterns = {"/login"})
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
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
		HttpSession session = request.getSession();
		String destPage = "login.jsp";
		if(session!=null && session.getAttribute("user")!=null) {
			destPage = "/home";
		}		
		request.getRequestDispatcher(destPage).forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDaoImpl();

		try {
			UserInfo user = userDao.checkLogin(email, password);
			String destPage = "login.jsp";

			if (user != null && user.getUserId() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				destPage = "/home";
			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

}
