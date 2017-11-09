<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="com.xlj.util.DbManager"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="java.io.InputStream"/>
<%
	out.clear();//清空一切输出
	int id=Integer.parseInt(request.getParameter("id"));
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		conn=DbManager.getConnection();
		pstmt=conn.prepareStatement("select * from tb_attachment where id=?");
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			response.reset();//重置response
			response.setContentType(rs.getString("filetype"));//设置输出文件类型
			response.setContentLength(rs.getInt("size"));//设置输出长度
			InputStream ins=null;//输入流，用于读取数据库
			OutputStream ous=null;//输出流，用于输出到客户端
			
			try{
				ins=rs.getBinaryStream("content");//取得ResultSet的二进制流
				ous=response.getOutputStream();//获取response的输出流
				byte[] b=new byte[1024];
				int len=0;
				while((len=ins.read(b))!=-1){//循环读入到缓存数组中
					ous.write(b,0,len);//循环输出到客户端
				}
			}finally{
				if(ous!=null) ous.close();
				if(ins!=null) ins.close();
			}
		}
	}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

</body>
</html>