<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<jsp:directive.page import="com.xlj.util.DbManager"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="org.apache.commons.fileupload.DiskFileUpload"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="org.apache.commons.fileupload.FileItem"/>

<jsp:directive.page import="java.sql.Timestamp"/>
	<%!
		public void init(){//加载JSP时执行SQL语句创建表
			try{
				DbManager.executeUpdate("create table if not exists tb_attachment "+
				"(id int auto_increment,filename varchar(255),filetype varchar(255),"+
				"size int ,content LONGBLOB,ip varchar(255),date timestamp,primary key(id))");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 %>
	 <%
	 	if("POST".equalsIgnoreCase(request.getMethod())){//如果是POST表单
	 		DiskFileUpload diskFileUpload=new DiskFileUpload();//使用DiskFileUpload
	 		diskFileUpload.setHeaderEncoding("UTF-8");//设置编码
	 		List<FileItem> list=diskFileUpload.parseRequest(request);//解析上传的数据
	 		for(FileItem fileItem:list){//遍历所有上传的域
	 			if(!fileItem.isFormField()){//如果是文件域
	 				String filename=fileItem.getName().replace("\\", "/");//文件路径
	 				filename=filename.substring(filename.lastIndexOf("/")+1);//获取文件名
	 				Connection conn=null;//Connection对象
	 				PreparedStatement pstmt=null;
	 				try{
	 					conn=DbManager.getConnection();//获取Connection
	 					pstmt=conn.prepareStatement("insert into tb_attachment "+
	 					"(filename,filetype,size,content,ip) values (?,?,?,?,?)");
	 					pstmt.setString(1, filename);
	 					pstmt.setString(2, fileItem.getContentType());//设置附件类型
	 					pstmt.setInt(3, (int)fileItem.getSize());//附件长度
	 					pstmt.setBinaryStream(4,
	 					 		fileItem.getInputStream(),//附件输入流
	 					 		(int)fileItem.getSize());//附件长度
	 					pstmt.setString(5, request.getRemoteAddr());//上传者IP地址
	 					//System.out.println(new Timestamp(System.currentTimeMillis()));
	 					//pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
	 					pstmt.executeUpdate();//执行语句
	 				}finally{
	 					if(pstmt!=null) pstmt.close();
	 					if(conn!=null) conn.close();
	 				}
	 			}
	 		}
	 	}
	  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<a href="javascript:location=location;">刷新附件列表</a>
	<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=DbManager.getConnection();//获取Connection
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from tb_attachment order by id desc");
			out.println("<table>");
			out.println("<tr>");
			out.println("	<th>ID</th>");
			out.println("	<th>File Name</th>");
			out.println("	<th>File type</th>");
			out.println("	<th>Size</th>");
			out.println("	<th>IP</th>");
			out.println("	<th>Date</th>");
			out.println("	<th>Operation</th>");
			out.println("</tr>");
			
			while(rs.next()){
				out.println("<tr>");
				out.println("	<td>"+rs.getInt("id")+"</td>");
				out.println("	<td>"+rs.getString("filename")+"</td>");
				out.println("	<td>"+rs.getString("filetype")+"</td>");
				out.println("	<td>"+rs.getInt("size")+"</td>");
				out.println("	<td>"+rs.getString("ip")+"</td>");
				out.println("	<td>"+rs.getTimestamp("date")+"</td>");
				out.println("	<td><a href='download.jsp?id="+rs.getInt("id")+"'>下载</a></td>");
				out.println("</tr>");
			}
		}finally{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	 %>
	 <form action="${pageContext.request.requestURI }" enctype="multipart/form-data" method="post">
	 	<input name="file" type="file" />
	 	<input type="submit" value="开始上传">
	 </form>
</body>
</html>