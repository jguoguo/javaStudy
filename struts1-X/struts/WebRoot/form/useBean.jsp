<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<head>
		<title>JSP for HelloForm form</title>
	</head>
	<body>
		<html:form action="/useBean">
			<html:hidden property="action" value="add"/>
			账号:<html:text property="person.account"></html:text><br/>
			姓名:<html:text property="person.name"></html:text><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>