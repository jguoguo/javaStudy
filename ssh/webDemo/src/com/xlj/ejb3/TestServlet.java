package com.xlj.ejb3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet{
	
	@EJB
	IHelloEJBService service;//通过注解方式注入EJB

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"> ");
		out.println("<HTML>");
		out.println("<head><title>A servlet</title></head>");
		out.println("<body>");
		out.print(service.sayHelloEJB("web Client"));
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
}
