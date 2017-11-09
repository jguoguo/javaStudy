package com.bjpowernode.jstl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ≤‚ ‘jstl∏Ò ΩªØø‚
 * @author Administrator
 *
 */
public class JstlFmtServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("today", new Date());
		request.setAttribute("n", 12345678.123);
		request.setAttribute("p", 0.1234567);
		request.getRequestDispatcher("/jstl_fmt.jsp").forward(request, response);
	}
	
}
