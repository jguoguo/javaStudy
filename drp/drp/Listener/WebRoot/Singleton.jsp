<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.xlj.listener.singleton.PersonInfo" %>
<%@ page import="java.util.Date" %>
<%
	String action=request.getParameter("action");//获取action参数
	String account=request.getParameter("account");//获取account参数
	if("login".equals(action) && account.trim().length()>0){//如果为login动作
		PersonInfo personInfo=new PersonInfo();
		//登录，将personInfo放入Session
		personInfo.setAccount(account.trim().toLowerCase());//保存账户
		personInfo.setIp(request.getRemoteAddr());//保存IP地址
		personInfo.setLoginDate(new Date());//保存登录时间
		session.setAttribute("personInfo", personInfo);//保存到Session中
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
		return ;
	}else if("logout".equals(action)){//如果为logout动作
		session.removeAttribute("personInfo");//将personInfo从session中移除
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
		return;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		body {
			font-size:12px; 
		}
		</style>
	</head>
<body>
	<c:choose>
		
		<c:when test="${personInfo !=null }">
			欢迎您，${ personInfo.account }.<br/>
			您的登陆IP为${personInfo.ip },<br/>
			登录时间为<fmt:formatDate value="${personInfo.loginDate }" pattern="yyyy-MM-dd HH:mm"/>.
			<a href="${ pageContext.request.requestURI }?action=logout">退出</a>
			<!-- 每5秒钟刷新一次页面 -->
			<script>setTimeout("location=location;",5000)</script>
		</c:when>
		
		<c:otherwise>
			${msg }
			<c:remove var="msg" scope="session"/>
			<form action="${pageContext.request.requestURI }?action=login" method="post">
				账号：
				<input name="account" />
				<input type="submit" value="登录">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>