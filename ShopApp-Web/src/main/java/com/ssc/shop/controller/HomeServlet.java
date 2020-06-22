package com.ssc.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssc.shop.dao.UserDao;
import com.ssc.shop.dao.UserDaoImpl;
import com.ssc.shop.model.UserInfo;

/**
 * Servlet implementation class MyServlet
 */

@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String destPage = "login.jsp";
		if(session!=null && session.getAttribute("user")!=null) {
			destPage = "index.jsp";
			UserDao userDao=new UserDaoImpl();
			List<UserInfo> info = userDao.getAllUsers();
			request.setAttribute("result", info);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
