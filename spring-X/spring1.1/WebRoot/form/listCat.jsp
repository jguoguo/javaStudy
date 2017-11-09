<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
	<body>
		<html:form action="cat.do">
			<input type="hidden" name="action" value="add"/><!-- 隐藏域，action参数 -->
			<html:text property="name"></html:text><!-- 文本域，Cat的名称 -->
			<html:submit value="添加"></html:submit>
		</html:form>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>CreateDate</th>
			</tr>
			<logic:iterate id="cat" name="catList"><!-- 遍历Cat列表 -->
				<tr>
					<td><bean:write name="cat" property="id"/></td>
					<td><bean:write name="cat" property="name"/></td>
					<td><bean:write name="cat" property="createdDate" format="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</logic:iterate>
		</table>
	</body>
</html>