<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.apache.derby.jdbc.EmbeddedDriver" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		DriverManager.deregisterDriver(new EmbeddedDriver());//ע��Derby���ݿ�����
		Connection conn=DriverManager.getConnection("jdbc:derby:D:\\database_derby;create=true");
		Statement stmt=conn.createStatement();//����Statement
		try{
			stmt.execute("create table tb_test (id integer GENERATED always as indetity (start with 1,increment by 1),ip varchar(100),host text,date timestamp,primary key(id))");
			out.println("<div>��tb_test�����ڣ�������tb_test�ɹ�.</div>");
		}catch(SQLException e){
			out.println("<div>��tb_test����</div>");
		}
		try{
			int rows=stmt.executeUpdate("insert into tb_text(ip,host,date) values ('"+request.getRemoteAddr()+"','"+request.getServerName()+"',current_timestamp)");
			out.println("<div>�²���"+rows+"������.</div>");
		}catch(SQLException e){
			out.println("<div>��������ʧ�ܡ�ԭ��:"+e.getMessage()+".</div>");
		}
		ResultSet rs=stmt.executeQuery("select * from tb_test");
		//��ȡ���м�¼
		out.println("<table border=1>");
		out.println("	<tr>");
		out.println("		<td width=100 align=center>���ʴ���</td>");
		out.println("		<td width=200 align=center>������ IP ��ַ</td>");
		out.println("		<td width=200 align=center>ʹ�õ�����</td>");
		out.println("		<td width=200 align=center>��������</td>");
		out.println("	</tr>");
		// ѭ�����������е����ݼ�
		while(rs != null && rs.next()){
			out.println("	<tr>");
			out.println("		<td align=center>" + rs.getInt("id") + "</td>");
			out.println("		<td align=center>" + rs.getString("ip") + "</td>");
			out.println("		<td align=center>" + rs.getString("host") + "</td>");
			out.println("		<td align=center>" + rs.getTimestamp("date") + "</td>");
			out.println("	</tr>");
		}
		out.println("</table>");
		
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();
		if(conn != null)
			conn.close(); 
	 %>
</body>
</html>