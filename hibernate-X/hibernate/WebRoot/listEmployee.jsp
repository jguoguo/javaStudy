<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.xlj.hibernate.util.StringUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.xlj.hibernate.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String message=(String)request.getAttribute("message");//获取message
	if(StringUtil.isNull(message)){//如果不为空
		out.println("<div class=message>"+message+"</div>");
	}
 %>
<html>
<head>
	<script type="text/javascript">
	function listEmployee(){
		window.self.location ="EmployeeServlet?action=list&sort=id&order=asc";
	}
	function addEmployee(){
		window.self.location ="EmployeeServlet?action=add";
	}
	function queryEmployee(){
	/*
		var name=document.getElementById("name").value;	
		var sex=document.getElementById("sex").value;
		var ageOperate=document.getElementById("ageOperate").value;
		if(ageOperate=="big"){
			ageOperate=">";
		}else if(ageOperate=="litter"){
			ageOperate="<";
		}else if(ageOperate=="equal"){
			ageOperate="=";
		}
		var age=document.getElementById("age").value;
		var birthday=document.getElementById("birthday").value;
		var time=document.getElementById("time").value;
		var salaryOperate=document.getElementById("salaryOperate").value;
			if(salaryOperate=="big"){
				salaryOperate=">";
			}else if(salaryOperate=="litter"){
				salaryOperate="<";
			}else if(salaryOperate=="equal"){
				salaryOperate="=";
			}
		var salary=document.getElementById("salary").value;
		//alert(name+","+sex+","+ageOperate+","+age+","+birthday+","+time+","+salaryOperate+","+salary);
		window.self.location ="EmployeeServlet?action=list&sort=id&order=asc&name="+name+
				"&sex="+sex+"&ageOperate="+ageOperate+"&age="+age+"&birthday="+birthday+
				"&time="+time+"&salaryOperate="+salaryOperate+"&time="+salary;
				*/
		with(document.getElementById("userform")){
			action="EmployeeServlet?action=list&sort=id&order=asc";
			method="post";
			submit();
		}
	}
	</script>
</head>
<body>
	<input type="button" name="button1" value="员工列表" onclick="listEmployee()">
	<input type="button" name="button1" value="添加员工(随机)" onclick="addEmployee()"><br/><br/>
	<form name="userform" id="userform">
		姓名：<input type="text" name="name" id="name">&nbsp;&nbsp;

		性别：<select name="sex" id="sex">
				<option value="nan">男</option>
				<option value="nv">女</option>
			</select>&nbsp;&nbsp;
	
		年龄：<select name="ageOperate" id="ageOperate">
				<option value="big">></option>
				<option value="litter"><</option>
				<option value="equal">=</option>
			</select>
			<input type="text" name="age" id="age">&nbsp;&nbsp;<br/><br/>
	
		生日：<input type="text" name="birthday" id="birthday">e.g.2008-08-08&nbsp;&nbsp;
		上班时间：<input type="text" name="time" id="time">e.g.2008-08-08&nbsp;&nbsp;
		薪水：<select name="salaryOperate" id="salaryOperate">
				<option value="big">></option>
				<option value="litter"><</option>
				<option value="equal">=</option>
			</select>
		<input type="text" name="salary" id="salary"><br/>
	<input type="button" name="button3" value="查询" onclick="queryEmployee()">
	
	</form>
	
	<table>
		<tr>
			<%
				if("id".equals(request.getAttribute("sort"))){
			 %>
			 <th class="sortable sorted ${order }">
			 	<a href="${url }action=list&sort=id&order=${order=='asc'?'desc':'asc'}">编号</a></th>
			 <% 
			 	}else{ 
			 %>
			 <th class="sortable"><a href="${url }action=list&sort=id&order=asc">编号</a></th>
			 <% }%>
			 <th>姓名</th>
			 <th>性别</th>
			 <th>年龄</th>
			 <th>生日</th>
			 <th>薪水</th>
			 <th>上班时间</th>
			 <th>下班时间</th>
			 <th>状态</th>
			 <th class="sortable">操作</th>
		</tr>
		<%
			List<Employee> employeeList=(List<Employee>)request.getAttribute("employeeList");
			NumberFormat salaryFormat=new DecimalFormat("0.00");//薪水格式化器
			for(int i=0;employeeList!=null && i<employeeList.size();i++){
				Employee e=employeeList.get(i);
				out.println("<tr class='"+(i%2==0?"even":"odd")+"'>");
				out.println("<td>"+e.getId()+"</td>");
				out.println("<td>"+e.getName()+"</td>");
				out.println("<td>"+e.getSex()+"</td>");
				out.println("<td>"+e.getAge()+"</td>");
				out.println("<td>"+e.getBirthday()+"</td>");
				out.println("<td>￥"+salaryFormat.format(e.getSalary())+"</td>");
				out.println("<td>"+e.getStartTime()+"</td>");
				out.println("<td>"+e.getEndTime()+"</td>");
				out.println("<td>"+(e.isDisabled()?"已阻止":"正常")+"</td>");
				out.println("<td>&nbsp;</td>");
				out.println("</tr>");
			}
		 %>
	</table>
	<div style="padding-top:10px;font-size:12px;">
		${pagination }
	</div>
</body>
</html>