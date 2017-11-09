<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<a href="StudentServlet?action=add">添加随机记录</a>
	<a href="StudentServlet?action=list">所有记录列表</a><br/><br/>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${studentList }" var="student">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${student.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>