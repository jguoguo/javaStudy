<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.xlj.listener.singleton.PersonInfo" %>
<%@ page import="java.util.Date" %>
<%
	String action=request.getParameter("action");//��ȡaction����
	String account=request.getParameter("account");//��ȡaccount����
	if("login".equals(action) && account.trim().length()>0){//���Ϊlogin����
		PersonInfo personInfo=new PersonInfo();
		//��¼����personInfo����Session
		personInfo.setAccount(account.trim().toLowerCase());//�����˻�
		personInfo.setIp(request.getRemoteAddr());//����IP��ַ
		personInfo.setLoginDate(new Date());//�����¼ʱ��
		session.setAttribute("personInfo", personInfo);//���浽Session��
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
		return ;
	}else if("logout".equals(action)){//���Ϊlogout����
		session.removeAttribute("personInfo");//��personInfo��session���Ƴ�
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
			��ӭ����${ personInfo.account }.<br/>
			���ĵ�½IPΪ${personInfo.ip },<br/>
			��¼ʱ��Ϊ<fmt:formatDate value="${personInfo.loginDate }" pattern="yyyy-MM-dd HH:mm"/>.
			<a href="${ pageContext.request.requestURI }?action=logout">�˳�</a>
			<!-- ÿ5����ˢ��һ��ҳ�� -->
			<script>setTimeout("location=location;",5000)</script>
		</c:when>
		
		<c:otherwise>
			${msg }
			<c:remove var="msg" scope="session"/>
			<form action="${pageContext.request.requestURI }?action=login" method="post">
				�˺ţ�
				<input name="account" />
				<input type="submit" value="��¼">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>