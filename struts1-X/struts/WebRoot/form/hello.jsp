<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for HelloForm form</title>
	</head>
	<body>
		<html:form action="/hello">
			姓名 : <html:text property="name"/><html:errors property="name"/><br/>
			年龄:<html:text property="age"/><br/>
			是否用过struts?:<html:checkbox property="experience"/><br/>
			爱好:<html:checkbox property="hobby" value="音乐"/>音乐
			<html:checkbox property="hobby" value="体育"/>体育
			<html:checkbox property="hobby" value="影视"/>影视<br/>
			日期：<html:text property="date"/><br/>
			时间：<html:text property="time"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

