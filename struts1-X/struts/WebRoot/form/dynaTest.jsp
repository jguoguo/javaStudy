<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<html:form action="/dynaTest">
		年龄：<html:text property="age"></html:text><br/>
		姓名：<html:text property="name"></html:text><br/>
		生日：<html:text property="birthday"></html:text><br/>
		<html:submit></html:submit><html:cancel></html:cancel>
	</html:form>
</body>
</html>