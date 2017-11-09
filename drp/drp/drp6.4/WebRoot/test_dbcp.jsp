<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//JNDI����
	//new DBCP..
	try{
		Context ctx=new InitialContext();
		//ͨ��JNDI����DataSource
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/");//�õ�����Դ
		conn=ds.getConnection();
		pstmt=conn.prepareStatement("select * from t_user");
		rs=pstmt.executeQuery();
		while(rs.next()){
			out.println(rs.getString("user_id")+","+rs.getString("user_name"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs!=null){rs.close();}
		if(pstmt!=null){pstmt.close();}
		if(conn!=null){
			//��Connection�ŵ����ӳ���
			conn.close();
		}
	}
	
%>