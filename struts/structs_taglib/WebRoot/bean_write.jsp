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
	<h1>测试beanWrite标签</h1><br>
	<hr>
	<li>普通字符串</li>
	hello(标签):<bean:write name="hello"/><br>
	<p>
	<li>html文本</li>
	bj(default):<bean:write name="bj"/><br>
	bj(filter="true"):<bean:write name="bj" filter="true"/><br>
	bj(filter="false"):<bean:write name="bj" filter="false"/><br>
</body>
</html>