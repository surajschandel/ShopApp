package com.ssc.shop.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "refreshServlet", urlPatterns = { "/refreshSession" })
public class RefreshSessionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("refreshing session");
//		if (!req.isUserInRole("employee")) {
//			System.err.println("User logged out already, " + "set higher setMaxInactiveInterval() ");
//			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			return;
//		}
//		HttpSession session = req.getSession();
//		if (session == null) {
//			System.err.println("cannot renew session");
//		}
	}
}
