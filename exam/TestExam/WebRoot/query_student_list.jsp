<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.text.*"%>
<%@ page import="com.bjpowernode.exam.model.*"%>
<%@ page import="com.bjpowernode.exam.manager.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ѧ����Ϣ</title>
</head>
<body>
		<form action="query_student_list.jsp" method="post">
			�������ڣ�<input type="text" name="beginDate">��<input type="text" name="endDate">
			<input type="submit" value="��ѯѧ��">
		</form>
		<%
			String sBeginDate=request.getParameter("beginDate");
			String sEndDate=request.getParameter("endDate");

			Date beginDate=new Date();
			Date endDate=new Date();
			try{
				beginDate=new SimpleDateFormat("yyyy-MM-dd").parse(sBeginDate);
				endDate=new SimpleDateFormat("yyyy-MM-dd").parse(sEndDate);
			}catch(Exception e){
				e.printStackTrace();
			}

			StudentManager studentManager=new StudentManagerImpl();
			List<Student> studentList=studentManager.findStudentList(beginDate,endDate);
			if((studentList!=null) && (studentList.size()!=0)){
		%>
		<p>
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
		<%
		}
		%>
</body>
</html>