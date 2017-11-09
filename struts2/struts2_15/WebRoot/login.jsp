<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<!--  
	<form action="login.action">
		用户：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<input type="submit" value="登录">
	</form>
	-->
	<s:form action="login.action">
		<s:textfield name="username" key="login.form.field.username"></s:textfield>
		<s:password name="password" key="login.form.field.password"></s:password>
		<s:submit key="login.form.button.login" name="login"></s:submit>
	</s:form>
</body>
</html>