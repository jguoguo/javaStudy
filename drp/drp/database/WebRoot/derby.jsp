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
		DriverManager.deregisterDriver(new EmbeddedDriver());//注册Derby数据库驱动
		Connection conn=DriverManager.getConnection("jdbc:derby:D:\\database_derby;create=true");
		Statement stmt=conn.createStatement();//创建Statement
		try{
			stmt.execute("create table tb_test (id integer GENERATED always as indetity (start with 1,increment by 1),ip varchar(100),host text,date timestamp,primary key(id))");
			out.println("<div>表tb_test不存在，创建表tb_test成功.</div>");
		}catch(SQLException e){
			out.println("<div>表tb_test存在</div>");
		}
		try{
			int rows=stmt.executeUpdate("insert into tb_text(ip,host,date) values ('"+request.getRemoteAddr()+"','"+request.getServerName()+"',current_timestamp)");
			out.println("<div>新插入"+rows+"行数据.</div>");
		}catch(SQLException e){
			out.println("<div>插入数据失败。原因:"+e.getMessage()+".</div>");
		}
		ResultSet rs=stmt.executeQuery("select * from tb_test");
		//获取所有记录
		out.println("<table border=1>");
		out.println("	<tr>");
		out.println("		<td width=100 align=center>访问次序</td>");
		out.println("		<td width=200 align=center>访问者 IP 地址</td>");
		out.println("		<td width=200 align=center>使用的域名</td>");
		out.println("		<td width=200 align=center>访问日期</td>");
		out.println("	</tr>");
		// 循环遍历完所有的数据集
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