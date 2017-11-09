<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.bjpowernode.com/myfunctions" prefix="my"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	hello.length(jsp脚本):<%=((String)request.getAttribute("hello")).length() %><br>
	hello.length(使用JSTL的length函数，函数必须放到EL表达式中，用法：前缀+冒号+函数名称):${fn:length(hello) }<br>
	<p>
	<c:forEach items="${fn:split(str,\"#\")}" var="v">
		${v }<br>	
	</c:forEach>
	<p>
	自定义函数：${my:say("张三") }<br>
</body>
</html>