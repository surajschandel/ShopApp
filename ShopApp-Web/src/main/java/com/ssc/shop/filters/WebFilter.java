package com.ssc.shop.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class WebFilter
 */
public class WebFilter implements Filter {
	private FilterConfig filterConfig = null;

    /**
     * Default constructor. 
     */
    public WebFilter() {   }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filter destoryed");
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println("Filter called : " + request.getRemoteHost());
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, X-Auth-Token, Content-Type, Accept, Authorization");
		if (req.getMethod().equalsIgnoreCase("options")) {
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter FilterConfig");
		this.filterConfig = fConfig;
	}

}
