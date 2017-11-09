<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.xlj.hibernate.bean.Cat" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h4>${msg }</h4>
	所有Cat列表
	[<a href="catServlet?action=initAdd">添加 Cat</a>][<a href="catServlet?action=list">Cat列表</a>]
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Mother</th>
			<th>Operation</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			List<Cat> catList=(List<Cat>)request.getAttribute("catList");
			for(Cat cat:catList){
				out.write("<tr");
				out.write("<td>"+cat.getId()+"</td>");
				out.write("<td>"+cat.getName()+"</td>");
				out.write("<td>"+cat.getDescription()+"</td>");
				String motherString="";
				Cat mother=cat.getMother();
				while(mother!=null){
					if(motherString.trim().length()==0){
						motherString=mother.getName();
					}else{
						motherString=mother.getName()+"/"+motherString;
					}
					mother=mother.getMother();
				}
				out.write("<td>"+motherString+"</td>");
				out.write("<td>");
				out.write("  <a href=catServlet?action=delete&id="+cat.getId()+" onclick=\"return confirm('确认删除？');\">删除</a>");
				out.write("  <a href=catServlet?action=edit&id="+cat.getId()+">修改</a>");
				out.write("</td>");
				out.write("</tr>");
			}
		 %>
	</table>
</body>
</html>