package com.bjpowernode.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlFnServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("hello", "HelloWrold");
		request.setAttribute("str", "1#2#3#4");
		request.getRequestDispatcher("/jstl_fn.jsp").forward(request, response);
	}

}
