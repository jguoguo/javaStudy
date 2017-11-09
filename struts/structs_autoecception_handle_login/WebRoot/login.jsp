<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		<bean:message key="login.form.field.username"/>:<input type="text" name="username"><br>
		<bean:message key="login.form.field.password"/>:<input type="password" name="password"><br>
		<input type="submit" value="<bean:message key="login.form.button.login"/>">
	</form>
</body>
</html>