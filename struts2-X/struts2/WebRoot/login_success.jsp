<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>Insert title here</title>
	<title>My JSP 'index.jsp' starting page</title>
	<struts:head theme="ajax"/>
</head>
<body>
	${username }����¼�ɹ���<br/>
	��¼�ɹ�����ӭ�㣬<struts:property value="username"/>
</body>
</html>