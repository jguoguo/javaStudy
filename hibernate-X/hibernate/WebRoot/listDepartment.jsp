<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.xlj.hibernate.bean.Department" %>
<%@ page import="com.xlj.hibernate.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
	
		function addDepartment(){
			window.self.location ="DepartmentServlet?action=add&sort=id&order=asc";
		}
		function addEmployee(){
			window.self.location ="EmployeeServlet?action=add&sort=id&order=asc";
		}
		function listDepartment(){
			window.self.location ="DepartmentServlet?action=list&sort=id&order=asc";
		}
	
		function listEmployee(){
			window.self.location ="EmployeeServlet?action=list&sort=id&order=asc";
		}
		
		function queryDepartment(){
			with(document.getElementById("departmentform")){
				action="DepartmentServlet?action=list&sort=id&order=asc";
				method="post";
				submit();
			}
		}
	
	</script>
</head>
<body>
	<input type="button" name="button1" value="添加部门" onclick="addEmployee()">
	<input type="button" name="button2" value="添加员工(随机)" onclick="addEmployee()">
	<input type="button" name="button3" value="部门列表" onclick="listDepartment()">
	<input type="button" name="button4" value="员工列表" onclick="listEmployee()"><br/><br/>
	
	<form name="departmentform" id="departmentform">
		<div>
		
			名称：<input type="text" name="departmentName" id="departmentName">&nbsp;&nbsp;
	
			经理：<input type="text" name="manager" id=""manager"">&nbsp;&nbsp;
		
			员工数：<select name="employeeOperator" id="employeeOperator">
					<option value="big">></option>
					<option value="litter"><</option>
					<option value="equal">=</option>
				</select>
				<input type="text" name="employeeSize" id="employeeSize">&nbsp;&nbsp;<br/><br/>
		
		</div>
		<input type="button" name="button5" value="查询" onclick="queryDepartment()">
	</form>
	<table>
		<tr>
			<%
			if("id".equals(request.getAttribute("sort"))){
			%>
				<th class="sortable" sorted ${order }>
				<a href="${url }action=list&sort=id&order=${order=='asc'?'desc':'asc'}">编号</a>
				</th>
			<%
			}else{
			%>
				<th class="sortable">
					<a href="${url }action=list&sort=id&order=asc">编号</a>
				</th>
			<%
			}
			%>
			<td>部门名称</td>
			<td>部门经理</td>
			<td>员工数</td>
			<td>员工姓名</td>
		</tr>
		<%
			List<Department> departmentList=(List<Department>)request.getAttribute("departmentList");//获取部门列表
			for(int i=0;departmentList!=null && i<departmentList.size();i++){
				Department d=departmentList.get(i);//当前部门
				Employee lineManager=d.getLineManager();//部门经理
				out.println("<tr class='"+(i%2==0?"even":"odd")+"'>");
				out.println("<td>"+d.getId()+"</td>");//输出ID
				out.println("<td>"+d.getName()+"</td>");//输出部门名称
				out.println("<td>"+(lineManager==null?"":lineManager.getName())+"</td>");//输出经理
				out.println("<td>");
				out.println(d.getEmployee().size());//输出员工数
				if(d.getEmployee().size()>0){
					out.println("(");
					for(Employee ee:d.getEmployee()){//遍历员工
						out.println(ee.getName()+",");//输出员工姓名
					}
					out.println(")");
				}
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=DepartmentServlet?action=edit&id="+d.getId()+">修改</a>");
				out.println("<a onclick=\"return confirm('确定删除该部门?')\"href=DepartmentServlet?action=delete&id="+d.getId()+">删除</a>");
				out.println("</td>");
				out.println("</tr>");
				
			}
		 %>
	</table>
</body>
</html>