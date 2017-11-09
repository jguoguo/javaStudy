<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	发生错误，原因：
	${requestScope['org.apache.struts.action.EXCEPTION'].message }
	<input type="button" value="返回" onclick="history.go(-1)"/>
</body>
</html>