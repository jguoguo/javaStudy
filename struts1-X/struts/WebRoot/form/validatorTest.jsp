<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<html:form action="/validatorTest" onsubmit="return validateValidatorTestForm(this);">
		姓名：<html:text property="name"/><br/>
		年龄：<html:text property="age"/><br/>
		电子邮件：<html:text property="email"/><br/>
		<html:submit value="提交"></html:submit>
		<html:javascript formName="validatorTestForm"/>
	</html:form>
</body>
</html>