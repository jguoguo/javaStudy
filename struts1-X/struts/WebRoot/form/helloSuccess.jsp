<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	您好,${helloForm.name }.<br/><br/>
	您的年龄是：${helloForm.age },<br/>
	<c:choose>
		<c:when test="${helloForm.experience }">您以前用过Struts</c:when>
		<c:otherwise>您以前没有用过Struts.</c:otherwise>
	</c:choose>
	您的爱好是：
	<c:forEach items="${helloForm.hobby }" var="hobby">
		${hobby }
	</c:forEach>
	日期：${helloForm.date }<br/>
	时间：${helloForm.time }<br/>
</body>
</html>