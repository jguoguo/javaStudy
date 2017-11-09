package com.bjpowernode.drp.basedata.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	Map<String,Integer> map=new HashMap<String,Integer>();

	@Override
	public void init() throws ServletException {
		map.put("download/setup.exe", 0);
		map.put("/download/application.zip", 0);
		map.put("/download/01.map", 0);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename=request.getParameter("filename");
		if(filename!=null){//ͳ�����ش���
			int hit=map.get(filename);//ȡ���ش���
			map.put(filename, ++hit);//���ش���+1�󱣴�
			response.sendRedirect(request.getContextPath()+filename);
		}else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<html>");
			out.println("<head><title>�ļ�����</title></head>");
			out.println("<link rel=\"stylesheet\" href=\"style/drp.css\">");
			out.println("<body><br/>");
			out.println("<filedset align=center style=width:90%><legend>�ļ�����</legend>");
			out.println("<table width=100%>");
			out.println("<tr>");
			out.println("<td><b>�ļ���</b></td>");
			out.println("<td><b>���ش���</b></td>");
			out.println("<td><b>����</b></td>");
			out.println("</tr>");
			for(Entry<String,Integer>entry:map.entrySet()){
				out.println("<tr>");
				out.println("<td>"+entry.getKey()+"</td>");
				out.println("<td>"+entry.getValue()+"</td>");
				out.println("<td><a href='"+request.getRequestURI()+"?filename="+entry.getKey()
						+"'target='blank' onclick='location=location;'>����</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</legend>");
			out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
	}

	@Override
	public void destroy() {
		map=null;
	}
	
	
}
