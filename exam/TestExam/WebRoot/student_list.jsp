<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.bjpowernode.exam.model.*"%>
<html>
	<head>
		<title>ѧ����Ϣ</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>ѧ������</td>
				<td>����</td>
				<td>�Ա�</td>
				<td>��������</td>
				<td>��ϵ�绰</td>
				<td>��ͥ��ַ</td>
				<td>�༶����</td>
				<td>����</td>
			</tr>
			<%
				List<Student> studentList=(List)request.getAttribute("student_list");
				for(Iterator<Student> iter=studentList.iterator();iter.hasNext();){
				Student student=iter.next();
			 %>
			 <tr>
			 	<td><%=student.getStudentId() %></td>
			 	<td><%=student.getStudentName() %></td>
			 	<td><%=student.getSex() %></td>
			 	<td><%=new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()) %></td>
			 	<td><%=student.getContactTel() %></td>
			 	<td><%=student.getAddress() %></td>
			 	<td><%=student.getClasses().getClassedName() %></td>
			 	<td><%=(new Date().getTime()-student.getBirthday().getTime())/(1000*60*60*24)/365 %></td>
			 </tr>
			 
			 <%} %>
		</table>
	</body>
</html>