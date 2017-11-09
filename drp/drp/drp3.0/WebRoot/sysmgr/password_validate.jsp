<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.sysmgr.domain.*" %> 
<%@ page import="com.bjpowernode.drp.sysmgr.manager.*" %>   

	<%
		String password=request.getParameter("password");
		User user=(User)session.getAttribute("user_info");
		if(!(user.getPassword()).equals(password)){
			out.println("ÃÜÂë´íÎó£¬ÇëÖØÐÂÊäÈë");
		}
	 %>
