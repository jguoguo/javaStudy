<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<jsp:directive.page import="javax.sql.DataSource" />
<jsp:directive.page import="javax.naming.Context"/>
<jsp:directive.page import="javax.naming.InitialContext"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<sql:query var="rs" dataSource="jdbc/databaseWeb">
		select filename,filetype,size,ip from tb_attachment
	</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="row" items="${rs.rows}">
		${ row['filename'] },	${ row['filetype'] }, ${ row['size'] }<br />
	</c:forEach>
	
	<%
		Context initContext=new InitialContext();//ʵ����һ��InitialContext
		Context envContext=(Context)initContext.lookup("java:/comp/env");//��ȡ���е���Դ
		DataSource ds=(DataSource)envContext.lookup("jdbc/databaseWeb");//��ȡJNDI����Դ
		Connection conn=ds.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select filename,filetype,size,ip from tb_attachment");
		rs.close();
		stmt.close();
		conn.close();//�ر�Connection��ʵ�������ͷ�Connection������Դ�У������ǹر�
 	%>
</body>
</html>