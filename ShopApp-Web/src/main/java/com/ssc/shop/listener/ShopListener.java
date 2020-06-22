package com.ssc.shop.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ShopListener
 *
 */
public class ShopListener implements HttpSessionListener {
	private static int activeSessions = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(120);// in seconds
		activeSessions++;

		System.out.println("-- HttpSessionListener#sessionCreated invoked --"+ activeSessions);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("-- HttpSessionListener#sessionDestroyed invoked --" +activeSessions);
		if (activeSessions > 0)
			activeSessions--;

	}

	public static int getActiveSessions() {
		return activeSessions;
	}

}
