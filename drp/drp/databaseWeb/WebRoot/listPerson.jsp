<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<jsp:directive.page import="java.sql.Date" />
<jsp:directive.page import="java.sql.Timestamp" />
<jsp:directive.page import="java.sql.SQLException"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>My JSP 'listPerson.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">body, td, th, input {font-size:12px; text-align:center; }</style>
	</head>
	<body>

		<table align=right>
			<tr>
				<td>
					<a href="addPerson.jsp">�½���Ա����</a>
				</td>
			</tr>
		</table>
		<br />
		<br />
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		// ע�� MySQL ����. Ҳ����ʹ���������ַ�ʽ����һ��
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//new com.mysql.jdbc.Driver();
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		// ��ȡ���ݿ����ӡ� ���������ֱ�Ϊ ����URL���û���������
		conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/databaseWeb", 
							"root", 
							"Asdf-12345");
		
		// ��ȡ Statement�� Statement ��������ִ�� SQL���൱�ڿ���̨��
		stmt = conn.createStatement();
		
		// ʹ�� Statement ִ�� SELECT ��䡣���ؽ������
		rs = stmt.executeQuery("select * from tb_person");	
%>
		<form action="operatePerson.jsp" method=get>
			<table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
				<tr bgcolor=#DDDDDD>
					<th></th>
					<th>
						ID
					</th>
					<th>
						����
					</th>
					<th>
						Ӣ����
					</th>
					<th>
						�Ա�
					</th>
					<th>
						����
					</th>
					<th>
						����
					</th>
					<th>
						��ע
					</th>
					<th>
						��¼����ʱ��
					</th>
					<th>
						����
					</th>
				</tr>
				<%
					// �����������rs.next() ���ؽ�������Ƿ�����һ����¼������У��Զ���������һ����¼������ true
					while (rs.next()) {

						int id = rs.getInt("id"); // ��������
						int age = rs.getInt("age");

						String name = rs.getString("user_name"); // �ַ�������
						String englishName = rs.getString("english_name");
						String sex = rs.getString("sex");
						String description = rs.getString("description");

						Date birthday = rs.getDate("birthday"); // �������ͣ�ֻ��������Ϣ��û��ʱ����Ϣ
						Timestamp createTime = rs.getTimestamp("create_time"); // ʱ������ͣ�������������ʱ�䡣

						out.println("		<tr bgcolor=#FFFFFF>");
						out.println("	<td><input type=checkbox name=id value=" + id
						+ "></td>");
						out.println("	<td>" + id + "</td>");
						out.println("	<td>" + name + "</td>");
						out.println("	<td>" + englishName + "</td>");
						out.println("	<td>" + sex + "</td>");
						out.println("	<td>" + age + "</td>");
						out.println("	<td>" + birthday + "</td>");
						out.println("	<td>" + description + "</td>");
						out.println("	<td>" + createTime + "</td>");
						out.println("	<td>");
						out.println("		<a href='operatePerson.jsp?action=del&id="
						+ id + "' onclick='return confirm(\"ȷ��ɾ���ü�¼��\")'>ɾ��</a>");
						out.println("		<a href='operatePerson.jsp?action=edit&id="
						+ id + "'>�޸�</a>");
						out.println("	</td>");
						out.println("		</tr>");

					}
				%>
			</table>
			<table align=left>
				<tr>
					<td>
						<input type='hidden' value='del' name='action'>
						<a href='#'
							onclick="">ȫѡ</a>
						<a href='#'
							onclick="">ȡ��ȫѡ</a>
						<input type='submit'
							onclick="return confirm('����ɾ����ѡ��ļ�¼���Ƿ�ɾ����'); " value='ɾ��'>
					</td>
				</tr>
			</table>
		</form>
<%
	}catch(SQLException e){
		out.println("�������쳣��" + e.getMessage());
		e.printStackTrace();
	}finally{
			// �ر�
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
	}
%>
	</body>
</html>
