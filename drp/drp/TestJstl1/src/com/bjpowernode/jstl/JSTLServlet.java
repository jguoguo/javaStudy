package com.bjpowernode.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ≤‚ ‘EL±Ì¥Ô Ω
 * @author Administrator
 *
 */
public class JSTLServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("hello", "Hello World");
		request.getRequestDispatcher("/jstl_el.jsp").forward(request, response);
	}

}
