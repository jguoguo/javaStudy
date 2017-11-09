<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>测试iterator</h1>
	<hr>
	<table border="1">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>班级</td>
		</tr>
		<logic:empty name="user_list">
			<tr>
				<td colspan="3">没有符合条件的数据</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="user_list">
			<logic:iterate id="user" name="user_list">
				<tr>
					<td>
						<bean:write name="user" property="name"/>
					</td>
					<td>
						<bean:write name="user" property="age"/>
					</td>
					<td>
						<bean:write name="user" property="group.name"/>
					</td>
				</tr>			
			</logic:iterate>
		</logic:notEmpty>
	</table>
</body>
</html>