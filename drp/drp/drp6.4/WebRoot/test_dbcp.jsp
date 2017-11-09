<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//JNDI服务
	//new DBCP..
	try{
		Context ctx=new InitialContext();
		//通过JNDI查找DataSource
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/");//得到数据源
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
			//将Connection放到连接池中
			conn.close();
		}
	}
	
%>